import React, { Component } from 'react';
import styled from 'styled-components';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/core/styles';
import CompareChart from './CompareChart';
import Text, {Title} from '../Text';

class Reports extends Component {
  constructor(props) {
    super(props);
    this.state = {
        vitals : null,
        averages: null


    };



  }

  componentDidMount() {
  //  const vitalsString = window.PatientController.getUserVitals(this.props.user.email);
    // if (vitalsString) {
    //   const vitals = JSON.parse(vitalsString);
    //   if (vitals) {
    //    this.setState({vitals });
    //   }
    // }

    const vitals = [
      {
        weight: 150,
        height: 65,
        date: '05/09/2020'

      },
      {
        weight: 160,
        height: 65,
        date: '06/09/2020'

      },
      {
        weight: 157,
        height: 65,
        date: '07/09/2020'

      }
  ];

    const averages = {
      weight: {avg: 172, std: 29},
      height: {avg: 70, std: 4 }
    };


    this.setState({vitals, averages});

  }



  handleSubmitVitals = () => {
    const { email } = this.props.user;
    const { weight, bodyTemp, height, bpSystolic, bpDiastolic, respRate, pulseBPM } = this.state;
    window.PatientController.setUserVitals(JSON.stringify({ email, weight, bodyTemp, height, bpSystolic, bpDiastolic, respRate, pulseBPM }));
    this.props.onNotification('Your vitals were submitted!', 'message');
  }

  render() {
    const { classes } = this.props;
    //const { weight, bodyTemp, height, bpSystolic, bpDiastolic, respRate, pulseBPM } = this.state;
    const options = {
      scales: {
        xAxes: [{
          ticks: {
            beginAtZero: true,
            min: 0
          }
        }]
      }
    };

    return (
      <Wrapper>
           <Title>Patient Comparison Reports</Title>
           <CompareChart data={{labels: ["Your Weight","Average Weight"], title: "Weight Comparison", values: ["150","172"]}} options={options}/>
           <CompareChart data={{labels: ["Your Height","Average Height"], title: "Height Comparison", values: ["65","72"]}} options={options}/>

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
  justify-content: center;
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

export default withStyles(styles)(Reports);
