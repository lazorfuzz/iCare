import React, { Component } from 'react';
import styled from 'styled-components';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import CompareChart from './CompareChart';
import {Title} from '../Text';

class Reports extends Component {
  constructor(props) {
    super(props);
    this.state = {
        vitals : null,
        averages: null


    };
  }

  handlePrint = () => {
    this.props.onNotification('Print job started!');
    window.PrinterController.print();
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
        <Title>Patient Comparison Reports</Title>
        <CompareChart data={{labels: ["Your Weight","Average Weight"], title: "Weight Comparison (kg)", values: [vitals.weight,"62"]}} options={options}/>
        <CompareChart data={{labels: ["Your Height","Average Height"], title: "Height Comparison (cm)", values: [vitals.height,"175.4"]}} options={options}/>
        <Row>
          <Button
            variant="contained"
            color="secondary"
            classes={{ root: classes.vitalsButton }}
            onClick={this.handlePrint}
          >
            Print Report
          </Button>
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
  }
});

const Wrapper = styled.div`
  justify-content: center;
  display: flex;
  flex-flow: column;
  margin-left: 16px;
  padding-top: 16px;
`;

const Row = styled.div`
  display: flex;
  flex-flow: column;
  padding: 16px 0;
  align-items: center;
`;

export default withStyles(styles)(Reports);
