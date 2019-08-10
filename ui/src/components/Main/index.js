import React, { Component } from 'react';
import styled from 'styled-components';
import Card from '@material-ui/core/Card';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import { withStyles } from '@material-ui/core/styles';
import Text, {Title, AlertText} from '../Text';
import request from 'request-promise';

class Main extends Component {
  constructor(props) {
    super(props);
    this.state = {
      alerts: [],
      news: []
    };
  }

  componentDidMount() {
    const { user } = this.props;
    request(`https://leonflix.net/api/news/${user.role === 'doctor' ? 'CDC' : 'nurse'}`)
    .then((data) => {
      this.setState({ news: JSON.parse(data) });
    });
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

  generateNews = () => {
    const { classes } = this.props;
    const { news } = this.state;
    return (
      <List classes={{ root: classes.list }}>
        {
          news.map((n) => (
            <ListItem
              key={n.link}
              button
              classes={{ root: classes.listItem }}
            >
              <ListItemContent>
                <Text>
                {n.title}
                </Text>
              </ListItemContent>
            </ListItem>
          ))
        }
      </List>
    )
  }

  render() {
    const { classes } = this.props;
    const { alerts, news } = this.state;
    return (
      <Wrapper>
        <Title>Notifications</Title>
        {
          alerts.length === 0 || news.length === 0 ? (
            <Card>
            <CardBody>
              {
                this.props.user.role === 'patient' && 'You have no health notifications.'
              }
              {
                (this.props.user.role === 'doctor' || this.props.user.role === 'nurse') && news.length === 0 && 'Loading notifications...'
              }
              {
                (this.props.user.role === 'doctor' || this.props.user.role === 'nurse') && this.generateNews()
              }
            </CardBody>
          </Card>
          ) : this.generateAlerts()
        }
      </Wrapper>
    );
  }
}

const styles = ({
  listItem: {
    color: 'rgba(255, 255, 255, .5)',
    maxWidth: 600
  },
  listItemButton: {
    color: 'rgba(255, 255, 255, .5)'
  },
  list: {
    overflowX: 'hidden',
    overflowY: 'auto',
    maxHeight: 400,
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

const Divider = styled.hr`
  border: none;
  margin: 8px 0;
`;

const ListItemContent = styled.div`
  display: flex;
  width: 100%;
`;

export default withStyles(styles)(Main);