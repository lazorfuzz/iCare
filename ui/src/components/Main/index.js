import React, { Component } from 'react';
import styled from 'styled-components';
import Card from '@material-ui/core/Card';
import Text, {Title, AlertText} from '../Text';

class Main extends Component {
  constructor(props) {
    super(props);
    this.state = {
      alerts: []
    };
  }

  componentDidMount() {
    this.updateAlerts();
  }

  componentDidUpdate(prevProps) {
    const { vitals } = this.props;
    if (prevProps.vitals.height !== vitals.height || prevProps.vitals.weight !== vitals.weight) {
      this.updateAlerts();
    }
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
    return alerts.map((alert) => (
      <React.Fragment>
        <Card>
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
    const { alerts } = this.state;
    return (
      <Wrapper>
        <Title>Notifications</Title>
        {
          alerts.length === 0 ? (
            <Card>
            <CardBody>
              You have no health notifications.
            </CardBody>
          </Card>
          ) : this.generateAlerts()
        }
      </Wrapper>
    );
  }
}

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

const Divider = styled.hr`
  border: none;
  margin: 8px 0;
`;

export default Main;