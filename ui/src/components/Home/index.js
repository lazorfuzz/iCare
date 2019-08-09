import React, { Component } from 'react';
import IconButton from '@material-ui/core/IconButton';
import Tooltip from '@material-ui/core/Tooltip';
import HomeIcon from '@material-ui/icons/Home';
import PatientsIcon from '@material-ui/icons/SupervisorAccount';
import VitalsIcon from '@material-ui/icons/Equalizer';
import ReportsIcon from '@material-ui/icons/Assignment';
import PowerIcon from '@material-ui/icons/PowerSettingsNew';
import MedicationsIcon from '@material-ui/icons/ListAlt';
import { withStyles } from '@material-ui/core/styles';
import styled from 'styled-components';
import Vitals from '../Vitals';
import Reports from '../Reports';
import Main from '../Main';
import Patients from '../Patients';

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      page: '#main',
      vitals: {}
    };
  }

  componentDidMount() {
    if (window.PatientController) {
      const vitalsString = window.PatientController.getUserVitals(this.props.user.email);
      if (vitalsString) {
        const vitals = JSON.parse(vitalsString);
        if (vitals) {
          this.setState({ vitals });
        }
      }
    }
  }

  handleSetPage = (page) => this.setState({ page });

  handleVitalsChange = () => {
    const vitalsString = window.PatientController.getUserVitals(this.props.user.email);
    if (vitalsString) {
      const vitals = JSON.parse(vitalsString);
      if (vitals) {
        this.setState({ vitals });
      }
    }
  }

  render() {
    const { classes, user } = this.props;
    const { page, vitals } = this.state;
    return (
      <Wrapper>
        <NavigationBar>
          <Tooltip title="Main" placement="right">
            <IconButton
              classes={{ root: page === '#main' ? classes.selectedNavButton : classes.navButton }}
              onClick={() => this.handleSetPage('#main')}
            >
              <HomeIcon />
            </IconButton>
          </Tooltip>
          {
            (user.role === 'doctor' || user.role === 'nurse') &&
            <React.Fragment>
              <Tooltip title="Patients" placement="right">
                <IconButton
                  classes={{ root: page === '#patients' ? classes.selectedNavButton : classes.navButton }}
                  onClick={() => this.handleSetPage('#patients')}
                >
                  <PatientsIcon />
                </IconButton>
              </Tooltip>
              <Tooltip title="Medications" placement="right">
                <IconButton
                  classes={{ root: page === '#medications' ? classes.selectedNavButton : classes.navButton }}
                  onClick={() => this.handleSetPage('#medications')}
                >
                  <MedicationsIcon />
                </IconButton>
              </Tooltip>
            </React.Fragment>
          }
          {
            user.role === 'patient' &&
            <React.Fragment>
              <Tooltip title="Reports" placement="right">
                <IconButton
                  classes={{ root: page === '#reports' ? classes.selectedNavButton : classes.navButton }}
                  onClick={() => this.handleSetPage('#reports')}
                >
                  <ReportsIcon />
                </IconButton>
              </Tooltip>
              <Tooltip title="Vitals" placement="right">
                <IconButton
                  classes={{ root: page === '#vitals' ? classes.selectedNavButton : classes.navButton }}
                  onClick={() => this.handleSetPage('#vitals')}
                >
                  <VitalsIcon />
                </IconButton>
              </Tooltip>
            </React.Fragment>
          }
          <Tooltip title="Logout" placement="right">
            <IconButton
              classes={{ root: page === '#settings' ? classes.selectedNavButton : classes.navButton }}
              onClick={this.props.onLogOut}
            >
              <PowerIcon />
            </IconButton>
          </Tooltip>
        </NavigationBar>
        <PageContainer>
          {
            page === '#main' && <Main user={this.props.user} vitals={vitals} onNotification={this.props.onNotification} />
          }
          {
            page === '#vitals' && <Vitals user={this.props.user} vitals={vitals} onVitalsUpdate={this.handleVitalsChange} onNotification={this.props.onNotification} />
          }
          {
            page === '#reports' && <Reports user={this.props.user} vitals={vitals} onNotification={this.props.onNotification} />
          }
          {
            page === '#patients' && <Patients user={this.props.user} onNotification={this.props.onNotification}  />
          }
        </PageContainer>
      </Wrapper>
    );
  }
}

const styles = theme => ({
  navButton: {
    marginTop: '1.5em',
    color: 'rgb(29, 38, 43)'
  },
  selectedNavButton: {
    marginTop: '1.5em',
    color: theme.palette.primary.light,
  }
});

const Wrapper = styled.div`
  display: flex;
`;

const NavigationBar = styled.div`
  display: flex;
  flex-flow: column;
  align-items: center;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
  width: 80px;
  background: rgb(57, 65, 70);
  box-shadow: -1px -2px 41px -3px rgba(0,0,0,0.83);
  -webkit-box-shadow: -1px -2px 41px -3px rgba(0,0,0,0.83);
  -moz-box-shadow: -1px -2px 41px -3px rgba(0,0,0,0.83);
  transition: 150ms ease-in;
`;

const PageContainer = styled.div`
  margin-left: 80px;
  width: calc(100vw - 80px);
`;

export default withStyles(styles)(Home);
