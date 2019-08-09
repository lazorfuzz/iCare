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

class Patients extends Component {
  constructor(props) {
    super(props);
    this.state = {
      patients: [],
      allPatients: [],
      showAddPatient: false
    };
  }
  componentDidMount() {
    if (window.DoctorController) {
      this.fetchPatientLists();
    }
  }

  fetchPatientLists = () => {
    const patientsData = window.DoctorController.getAssignedPatients(this.props.user.id);
    const allPatientsData = window.PatientController.getAllPatients();
    this.setState({
      patients: JSON.parse(patientsData),
      allPatients: JSON.parse(allPatientsData)
    });
  }

  generatePatientsDropdown = () => {
    const { allPatients, patients } = this.state;
    const patientsNotAssignedToMe = allPatients.filter((patient) => {
      return patients.filter(p => p.patientId === patient.id).length === 0;
    });
    return patientsNotAssignedToMe.map((patient) => (
      <option key={patient.email} value={patient.id}>{patient.firstName} {patient.lastName}</option>
    ));
  }

  generateAssignedPatients = () => {
    const { classes } = this.props;
    const { patients, allPatients } = this.state;
    return allPatients.filter((patient) => {
      return patients.filter(p => p.patientId === patient.id).length > 0;
    }).map((patient) => (
      <ListItem
        key={patient.email}
        button
        classes={{ root: classes.listItem }}
      >
        <ListItemContent>
          <Text>
          {`${patient.firstName} ${patient.lastName}`}
          </Text>
          <IconButton
            classes={{ root: classes.listItemButton }}
            onClick={() => this.handleUnassignPatient(patient.id)}
          >
            <DeleteIcon />
          </IconButton>
        </ListItemContent>
      </ListItem>
    ));
  }

  handleAssignPatient = () => {
    const { selectedAvailablePatient } = this.state;
    const setAssign = window.DoctorController.setDoctorPatientMapping(JSON.stringify({
      doctorId: this.props.user.id,
      patientId: selectedAvailablePatient
    }), true);
    if (setAssign) {
      this.fetchPatientLists();
    }
  }

  handleUnassignPatient = (patientId) => {
    window.DoctorController.setDoctorPatientMapping(JSON.stringify({
      doctorId: this.props.user.id,
      patientId
    }), false);
    this.fetchPatientLists();
  }

  render() {
    const { classes } = this.props;
    const { patients, selectedAvailablePatient, showAddPatient } = this.state;
    return (
      <Wrapper>
        <Title>My Patients</Title>
        <Card>
          <CardBody>
            {
              patients.length === 0 ? <Text>There are no patients assigned to you.</Text> :
              <List>
                {this.generateAssignedPatients()}
              </List>
            }
          </CardBody>
        </Card>
        <Tooltip title="Add a Patient">
        <Fab
          color="primary"
          onClick={() => this.setState({ showAddPatient: true })}
          classes={{ root: classes.fab }}
        >
          <AddIcon />
        </Fab>
        </Tooltip>
        <Dialog
          open={showAddPatient}
          onClose={() => this.setState({ showAddPatient: false })}
        >
          <DialogContent classes={{ root: classes.dialogContent }}>
            <Select
              native
              autoWidth
              value={selectedAvailablePatient}
              onChange={(evt) => this.setState({ selectedAvailablePatient: evt.target.value })}
            >
              {this.generatePatientsDropdown()}
            </Select>
            <Button
              variant="contained"
              color="primary"
              classes={{ root: classes.button }}
              onClick={this.handleAssignPatient}
            >
              Assign To Me
            </Button>
          </DialogContent>
        </Dialog>
      </Wrapper>
    );
  }
}

const styles = ({
  button: {
    marginLeft: 16
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
    padding: '16px 32px'
  },
  fab: {
    position: 'fixed',
    bottom: 48,
    right: 48
  }
})

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
  margin: 16px 0;
  margin-bottom: 24px;
  justify-content: flex-start;
  align-items: flex-start;
`;

const ListItemContent = styled.div`
  display: flex;
  width: 100%;
  justify-content: space-between;
`;


export default withStyles(styles)(Patients);
