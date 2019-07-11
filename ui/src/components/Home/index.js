import React, { Component } from 'react';
import IconButton from '@material-ui/core/IconButton';
import Tooltip from '@material-ui/core/Tooltip';
import HomeIcon from '@material-ui/icons/Home';
import PatientsIcon from '@material-ui/icons/SupervisorAccount';
import VitalsIcon from '@material-ui/icons/Equalizer';
import ReportsIcon from '@material-ui/icons/Assignment';
import SettingsIcon from '@material-ui/icons/Settings';
import MedicationsIcon from '@material-ui/icons/ListAlt';
import { withStyles } from '@material-ui/core/styles';
import styled from 'styled-components';

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      page: '#main',
    };
  }

  handleSetPage = (page) => this.setState({ page });

  render() {
    const { classes, user } = this.props;
    const { page } = this.state;
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
          <Tooltip title="Reports" placement="right">
            <IconButton
              classes={{ root: page === '#reports' ? classes.selectedNavButton : classes.navButton }}
              onClick={() => this.handleSetPage('#reports')}
            >
              <ReportsIcon />
            </IconButton>
          </Tooltip>
          {
            user.role === 'patient' &&
            <Tooltip title="Vitals" placement="right">
              <IconButton
                classes={{ root: page === '#vitals' ? classes.selectedNavButton : classes.navButton }}
                onClick={() => this.handleSetPage('#vitals')}
              >
                <VitalsIcon />
              </IconButton>
            </Tooltip>
          }
          <Tooltip title="Settings" placement="right">
            <IconButton
              classes={{ root: page === '#settings' ? classes.selectedNavButton : classes.navButton }}
              onClick={() => this.handleSetPage('#settings')}
            >
              <SettingsIcon />
            </IconButton>
          </Tooltip>
        </NavigationBar>
        <PageContainer>

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
  width: calc(100% - 80px);
`;

export default withStyles(styles)(Home);