import React, { Component } from 'react';
import styled from 'styled-components';
import { withStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import Button from '@material-ui/core/Button';
import CompareChart from './CompareChart';
import Text, {Title, AlertText} from '../Text';

class Reports extends Component {
  constructor(props) {
    super(props);
    this.state = {
        vitals : null,
        averages: null,
        alerts: []
    };
  }

  componentDidMount() {
    this.updateAlerts();
  }

  handlePrint = () => {
    this.props.onNotification('Print job started!');
    window.PrinterController.print();
  }

  updateAlerts = () => {
    const { vitals } = this.props;
    if (window.NotificationsController && vitals.hasOwnProperty('height')) {
      const bmiAlert = window.NotificationsController.calculateAdultBMI(vitals.weight.toString(), vitals.height.toString());
      const bpAlert = window.NotificationsController.bloodPressureChecks(vitals.bpSystolic.toString(), vitals.bpDiastolic.toString());
      this.setState({ alerts: [bmiAlert, bpAlert] });
    }
  }

  generateAlerts = () => {
    const { alerts } = this.state;
    const { classes } = this.props;
    return alerts.map((alert) => (
      <React.Fragment key={alert}>
        <Card classes={{ root: classes.card }}>
          <CardBody>
            {
              alert.includes('normal') ? <Text>{alert}</Text> : <AlertText>{alert}</AlertText>
            }
          </CardBody>
        </Card>
        <Divider />
      </React.Fragment>
    ));
  }

  render() {
    const { vitals, classes } = this.props;
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
        <Title>Patient Reports</Title>
        {
          vitals.weight &&
          <CompareChart
            data={{
              labels: ["Your Weight","Average Weight"],
              title: "Weight Comparison (kg)",
              values: [vitals.weight,"62"]
            }}
            options={options}
          />
        }
        {
          vitals.height &&
          <React.Fragment>
            <CompareChart
              data={{
                labels: ["Your Height","Average Height"],
                title: "Height Comparison (cm)",
                values: [vitals.height,"175.4"]
              }}
              options={options}
            />
            <Divider />
          </React.Fragment>
        }
        {
          vitals.height && this.generateAlerts()
        }
        {
          !vitals.height && 
          <Row>
            <Text>No Reports found. Please input your vitals.</Text>
          </Row>
        }
        <Row>
          {
            vitals.height &&
            <Button
              variant="contained"
              color="secondary"
              classes={{ root: classes.vitalsButton }}
              onClick={this.handlePrint}
            >
              Print Report
            </Button>
          }
        </Row>
      </Wrapper>
    );
  }
}

const styles = ({
  vitalsInput: {
    margin: 16,
  },
  vitalsButton: {
    width: 300
  },
  card: {
    marginTop: 8,
    width: 800,
    marginLeft: 32
  }
});

const Wrapper = styled.div`
  justify-content: center;
  display: flex;
  flex-flow: column;
  margin-left: 16px;
  padding-top: 16px;
`;

const Divider = styled.hr`
  border: none;
  margin: 8px 0;
`;

const CardBody = styled.div`
  margin: 8px;
  width: 600px;
`;

const Row = styled.div`
  display: flex;
  flex-flow: column;
  padding: 16px 0;
  align-items: center;
`;

export default withStyles(styles)(Reports);
