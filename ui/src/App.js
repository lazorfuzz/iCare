import React, { Component } from 'react';
import styled from 'styled-components';
import Snackbar from '@material-ui/core/Snackbar';
import { MuiThemeProvider, withStyles } from '@material-ui/core/styles';
import Login from './components/Login';
import Home from './components/Home';
import muiTheme from './mui-theme';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      path: 'home',
      showSnack: false,
      snackData: { message: 'Login failed.', type: 'error' },
      user: { firstName: 'Student', lastName: 'Jackson', email: 'student@psu.edu', role: 'patient' }
    };
  }

  handleSnackbarClose = () => this.setState({ showSnack: false });

  handleShowSnack = (message, type) => {
    this.setState({
      showSnack: true,
      snackData: { message, type }
    });
  }

  handleLoggedIn = (user) => {
    this.setState({
      user,
      path: 'home'
    });
  }

  render() {
    const { path, showSnack, snackData, user } = this.state;
    const { classes } = this.props;
    return (
      <MuiThemeProvider theme={muiTheme}>
        <Wrapper>
          {
            path === 'login' &&
            <Login onNotification={this.handleShowSnack} onLoggedIn={this.handleLoggedIn} />
          }
          {
            path === 'home' &&
            <Home user={user} onNotification={this.handleShowSnack} />
          }
        </Wrapper>
        <Snackbar
          className="snack"
          classes={{ anchorOriginBottomCenter: classes.snackbar }}
          open={showSnack}
          autoHideDuration={5000}
          onClose={this.handleSnackbarClose}
          ContentProps={{
            'aria-describedby': 'message-id',
          }}
          message={<SnackMessage id="message-id" type={snackData.type}>{snackData.message}</SnackMessage>}
        />
      </MuiThemeProvider>
    );
  }
}

const styles = ({
  snackbar: {
    backgroundColor: 'inherit',
    textAlign: 'center',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center'
  }
});

const Wrapper = styled.div`
  display: flex;
`;

const SnackMessage = styled.span`
  font-weight: bold;
  color: ${({type}) => type === 'error' ? '#e87272' : 'rgb(29, 38, 43)'};
`;

export default withStyles(styles)(App);
