import React, { Component } from 'react';
import styled from 'styled-components';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/core/styles';

class Vitals extends Component {
  constructor(props) {
    super(props);
    this.state = {
      weight: null,
      bodyTemp: null,
      height: null,
      bpSystolic: null,
      bpDiastolic: null,
      respRate: null,
      pulseBPM: null
    };
  }

  componentDidMount() {
    const vitalsString = window.PatientController.getUserVitals(this.props.user.email);
    if (vitalsString) {
      const vitals = JSON.parse(vitalsString);
      if (vitals) {
        const { weight, bodyTemp, height, bpSystolic, bpDiastolic, respRate, pulseBPM } = vitals;
        this.setState({ weight, bodyTemp, height, bpSystolic, bpDiastolic, respRate, pulseBPM });
      }
    }
  }

  handleSubmitVitals = () => {
    const { email } = this.props.user;
    const { weight, bodyTemp, height, bpSystolic, bpDiastolic, respRate, pulseBPM } = this.state;
    window.PatientController.setUserVitals(JSON.stringify({ email, weight, bodyTemp, height, bpSystolic, bpDiastolic, respRate, pulseBPM }));
    this.props.onNotification('Your vitals were submitted!', 'message');
  }

  render() {
    const { classes } = this.props;
    const { weight, bodyTemp, height, bpSystolic, bpDiastolic, respRate, pulseBPM } = this.state;
    return (
      <Wrapper>
        <Fields>
          <TextField
            label="Weight"
            helperText="(pounds)"
            classes={{ root: classes.vitalsInput }}
            inputProps={{ type: 'number' }}
            value={weight}
            onChange={(evt) => this.setState({ weight: evt.target.value })}
          />
          <TextField
            label="Height"
            helperText="(inches)"
            classes={{ root: classes.vitalsInput }}
            inputProps={{ type: 'number' }}
            value={height}
            onChange={(evt) => this.setState({ height: evt.target.value })}
          />
          <TextField
            label="Body Temperature"
            helperText="(Fahrenheit)"
            classes={{ root: classes.vitalsInput }}
            inputProps={{ type: 'number' }}
            value={bodyTemp}
            onChange={(evt) => this.setState({ bodyTemp: evt.target.value })}
          />
          <TextField
            label="Blood Pressure"
            helperText="(systolic)"
            classes={{ root: classes.vitalsInput }}
            inputProps={{ type: 'number' }}
            value={bpSystolic}
            onChange={(evt) => this.setState({ bpSystolic: evt.target.value })}
          />
          <TextField
            label="Blood Pressure"
            helperText="(diastolic)"
            classes={{ root: classes.vitalsInput }}
            inputProps={{ type: 'number' }}
            value={bpDiastolic}
            onChange={(evt) => this.setState({ bpDiastolic: evt.target.value })}
          />
          <TextField
            label="Respiration Rate"
            helperText="(breaths/min)"
            classes={{ root: classes.vitalsInput }}
            inputProps={{ type: 'number' }}
            value={respRate}
            onChange={(evt) => this.setState({ respRate: evt.target.value })}
          />
          <TextField
            label="Pulse"
            helperText="(beats/min)"
            classes={{ root: classes.vitalsInput }}
            inputProps={{ type: 'number' }}
            value={pulseBPM}
            onChange={(evt) => this.setState({ pulseBPM: evt.target.value })}
          />
        </Fields>
        <Options>
          <Button
            variant="contained"
            color="primary"
            classes={{ root: classes.vitalsButton }}
            onClick={this.handleSubmitVitals}
          >
            Save Vitals
          </Button>
        </Options>
      </Wrapper>
    );
  }
}

const styles = ({
  vitalsInput: {
    margin: 16,
  },
  vitalsButton: {
    width: 200
  }
});

const Wrapper = styled.div`
  display: flex;
  flex-flow: column;
  margin-left: 16px;
  padding-top: 16px;
`;

const Fields = styled.div`
  display: flex;
  flex-flow: row wrap;
`;

const Options = styled.div`
  display: flex;
  margin-top: 32px;
`;

export default withStyles(styles)(Vitals);