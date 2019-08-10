import React, { Component } from 'react';
import styled from 'styled-components';
import { withStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import List from '@material-ui/core/List';
import Dialog from '@material-ui/core/Dialog';
import DialogContent from '@material-ui/core/DialogContent';
import ListItem from '@material-ui/core/ListItem';
import Button from '@material-ui/core/Button';
import Fab from '@material-ui/core/Fab';
import Tooltip from '@material-ui/core/Tooltip';
import Select from '@material-ui/core/Select';
import IconButton from '@material-ui/core/IconButton';
import DeleteIcon from '@material-ui/icons/Delete';
import AddIcon from '@material-ui/icons/Add';
import Text, {Title} from '../Text';
import Input from '../Input';
import drugs from '../../drugs';
import {toTitleCase} from './util';

class Medications extends Component {
  constructor(props) {
    super(props);
    const drugsList = [...new Set(drugs.results.map(d => toTitleCase(d.term.toLowerCase())))];
    this.state = {
      patients: [],
      allPatients: [],
      showAddPatient: false,
      selectedPatientData: {},
      allMeds: drugsList,
      narrowedMeds: [],
      selectedMeasurement: 'mg/mL',
      selectedPatientMedications: [],
      drugName: '',
      dosage: '',
      count: 0
    };
  }
  componentDidMount() {
    if (window.DoctorController) {
      this.fetchPatientLists();
    }
  }

  fetchPatientLists = () => {
    const patients = JSON.parse(window.DoctorController.getAssignedPatients(this.props.user.id));
    const allPatientsData = window.PatientController.getAllPatients();
    this.setState({
      patients,
      allPatients: JSON.parse(allPatientsData),
    });
    if (patients.length > 0) {
      this.handleSelectPatient({ target: { value: patients[0].patientId } });
    }
  }

  fetchPatientMedications = (patientId) => {
    const medicationsData = window.PatientController.getPatientMedications(patientId);
  }

  generatePatientsDropdown = () => {
    const { allPatients, patients } = this.state;
    const patientsAssignedToMe = allPatients.filter((patient) => {
      return patients.filter(p => p.patientId === patient.id).length > 0;
    });
    return patientsAssignedToMe.map((patient) => (
      <option key={patient.email} value={patient.id}>{patient.firstName} {patient.lastName}</option>
    ));
  }

  generateMedications = () => {
    const { classes } = this.props;
    const { selectedPatientMedications } = this.state;
    if (!selectedPatientMedications.length) {
      return (
        <Text>This patient has no medications.</Text>
      )
    }
    return selectedPatientMedications.map((med) => (
      <ListItem
        key={med.name}
        button
      >
        <ListItemContent>
          <Text>{`${med.name} ${med.dosage}${med.measurementUnit} ${med.count ? `${med.count}x` : ''}`}</Text>
          <IconButton
            classes={{ root: classes.listItemButton }}
            onClick={() => {
              window.PatientController.setPatientMedication(JSON.stringify({ name: med.name, patientId: med.patientId }), false);
              this.handleSelectPatient({ target: { value: med.patientId } });
            }}
          >
            <DeleteIcon />
          </IconButton>
        </ListItemContent>
      </ListItem>
    ));
  }

  handleSelectPatient = (evt) => {
    const patientId = evt.target.value
    const patientData = window.PatientController.getPatientById(patientId);
    const patientMedsData = window.PatientController.getPatientMedications(patientId);
    this.setState({
      selectedPatient: patientId,
      selectedPatientData: JSON.parse(patientData),
      selectedPatientMedications: JSON.parse(patientMedsData)
    });
  }

  handleMedicationSuggestion = (evt) => {
    const { allMeds } = this.state;
    const text = evt.target.value;
    this.setState({ drugName: text });
    if (!text) {
      return this.setState({ narrowedMeds: [] });
    }
    const possibleMeds = allMeds.filter(m => m.toLowerCase().startsWith(text.toLowerCase()));
    this.setState({ narrowedMeds: possibleMeds.splice(0, 2) });
  }

  handleSelectMeasurement = (evt) => {
    this.setState({ selectedMeasurement: evt.target.value });
  }

  generateMedSuggestions = () => {
    return (
      <List classes={{ root: this.props.classes.suggestionList }}>
        {
          this.state.narrowedMeds.map((med) => (
            <ListItem classes={{root: this.props.classes.suggestionItem }} button key={med} onClick={() => this.setState({ drugName: med, narrowedMeds: [] })}>
              {med}
            </ListItem>
          ))
        }
      </List>
    )
  }

  handleAddMedication = () => {
    const { drugName, selectedMeasurement, dosage, count, selectedPatient } = this.state;
    window.PatientController.setPatientMedication(JSON.stringify({
      name: drugName,
      dosage: parseInt(dosage),
      measurementUnit: selectedMeasurement,
      isPrescription: selectedMeasurement === 'mg/day',
      count: parseInt(count),
      patientId: selectedPatient
    }), true);
    this.handleSelectPatient({ target: { value: selectedPatient }});
    this.setState({
      drugName: '',
      dosage: 0,
      count: 0
    });
  }

  render() {
    const { classes, user } = this.props;
    const { patients, selectedPatient, selectedPatientData, showAddMedication, selectedMeasurement, narrowedMeds, drugName, dosage, count } = this.state;
    return (
      <Wrapper>
        {
          user.role === 'doctor' || user.role === 'nurse' ? <Title>Patient Medications</Title> :
          <Title>My Medications</Title>
        }
        {
          (user.role === 'doctor' || user.role === 'nurse') &&
          <Select
            native
            value={selectedPatient}
            onChange={this.handleSelectPatient}
          >
            {this.generatePatientsDropdown()}
          </Select>
        }
        <Card classes={{ root: classes.card }}>
          <CardBody>
            {
              patients.length === 0 ? <Text>There are no patients assigned to you.</Text> :
              <React.Fragment>
                {
                  selectedPatientData.propertyIsEnumerable('firstName') &&
                  <React.Fragment>
                    <Text>{selectedPatientData.firstName} {selectedPatientData.lastName}&apos;s Medications</Text>
                    <List>
                      {this.generateMedications()}
                    </List>
                  </React.Fragment>
                }
              </React.Fragment>
            }
          </CardBody>
        </Card>
        <Tooltip title="Add Medication">
        <Fab
          color="primary"
          onClick={() => this.setState({ showAddMedication: true })}
          classes={{ root: classes.fab }}
        >
          <AddIcon />
        </Fab>
        </Tooltip>
        <Dialog
          open={showAddMedication}
          onClose={() => this.setState({ showAddMedication: false })}
        >
          <DialogContent classes={{ root: classes.dialogContent }}>
            <Row>
              <AutoComplete>
                <Input
                  type="text"
                  ref={(inp) => this.medInput = inp}
                  value={drugName}
                  onChange={this.handleMedicationSuggestion}
                  placeholder="Drug Name"
                />
                {
                  narrowedMeds.length > 0 && this.generateMedSuggestions()
                }
              </AutoComplete>
            </Row>
            <Row>
              <Input
                className={classes.dosageInput}
                type="text"
                ref={(inp) => this.medInput = inp}
                value={dosage}
                onChange={(evt) => this.setState({ dosage: evt.target.value })}
                placeholder="Dosage"
              />
              <Select
                native
                autoWidth
                value={selectedMeasurement}
                onChange={this.handleSelectMeasurement}
              >
                {
                  user.role === 'doctor' && <option value="mg/day">mg/day</option>
                }
                <option value="mg/mL">mg/mL</option>
              </Select>
            </Row>
            {
              selectedMeasurement === 'mg/day' &&
              <Row>
                <Input
                  type="number"
                  ref={(inp) => this.countInput = inp}
                  value={count}
                  onChange={(evt) => this.setState({ count: evt.target.value })}
                  placeholder="Count"
                />
              </Row>
            }
            <Row>
              <Button
                variant="contained"
                color="primary"
                classes={{ root: classes.button }}
                onClick={this.handleAddMedication}
              >
                Add Medication
              </Button>
            </Row>
          </DialogContent>
        </Dialog>
      </Wrapper>
    );
  }
}

const styles = ({
  card: {
    margin: '8px 0'
  },
  button: {
    width: '100%'
  },
  selectLabel: {
    margin: 'auto 0',
    marginRight: 8
  },
  listItem: {
    color: 'rgba(255, 255, 255, .5)'
  },
  listItemButton: {
    color: 'rgba(255, 255, 255, .5)'
  },
  dialogContent: {
    padding: '16px 32px',
    display: 'flex',
    flexFlow: 'column',
    zIndex: 10,
  },
  fab: {
    position: 'fixed',
    bottom: 48,
    right: 48
  },
  dosageInput: {
    width: 56,
    marginRight: 16
  },
  suggestionList: {
    position: 'absolute',
    zIndex: 1000,
    background: 'white',
    color: '#333',
    width: '220px',
    top: 64,
    borderRadius: 8
  },
  suggestionItem: {
    overflow: 'hidden',
    whiteSpace: 'nowrap',
    textTransform: 'capitalize',
    '&:hover': {
      background: 'rgba(0, 0, 0, .3)'
    }
  }
});

const Wrapper = styled.div`
  display: flex;
  flex-flow: column;
  align-items: center;
  margin-left: 16px;
  padding-top: 16px;
`;

const CardBody = styled.div`
  margin: 8px;
  min-width: 600px;
`;

const Row = styled.div`
  display: flex;
  margin: 8px 0;
`;

const ListItemContent = styled.div`
  display: flex;
  width: 100%;
  justify-content: space-between;
`;

const AutoComplete = styled.div`
  display: flex;
  flex-flow: column;
`;


export default withStyles(styles)(Medications);
