import React, { Component } from 'react';
import uuidv4 from 'uuid/v4';
import EmailIcon from '@material-ui/icons/Email';
import PersonIcon from '@material-ui/icons/Person';
import VPNKeyIcon from '@material-ui/icons/VpnKey';
import Button from '@material-ui/core/Button';
import styled from 'styled-components';
import Card from '@material-ui/core/Card';
import { withStyles } from '@material-ui/core/styles';
import { motion } from "framer-motion";
import { BaseInput, InputContainer } from '../Input';
import './Login.css';

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: '',
      firstName: '',
      lastName: '',
      creatingAccount: false,
      showLogo: true,
    };
  }

  componentDidMount() {
    setTimeout(() => this.setState({ showLogo: false }), 2900);
  }

  handleLogin = (evt) => {
    const { email, password } = this.state;
    const loggedIn = window.LoginController.authenticate(email, password);
    this.props.onNotification(loggedIn ? 'Logged in!' : 'Login failed!', loggedIn ? 'message' : 'error');
    if (loggedIn) {
      evt.preventDefault();
      this.props.onLoggedIn(JSON.parse(window.LoginController.getUserByEmail(email)));
    }
  }

  handleCreateAccount = (evt) => {
    const { firstName, lastName, email, password } = this.state;
    const user =  { firstName, lastName, email, password, role: 'patient', id: uuidv4() };
    const createdAccount = window.LoginController.createUser(JSON.stringify(user));
    if (createdAccount) {
      evt.preventDefault();
      this.setState({ creatingAccount: false, password: '' });
      this.props.onNotification('Account created!');
    }
  }

  handleToggleLogin = () => {
    const { creatingAccount } = this.state;
    this.setState({ creatingAccount: !creatingAccount });
  }

  render() {
    const { username, password, firstName, lastName, creatingAccount, showLogo } = this.state;
    const { classes } = this.props;

    return (
      <Wrapper>
        {
          showLogo &&
          <motion.div
            initial={{ y: -70, opacity: 0 }}
            animate={{ y: 0, opacity: 1 }}
            transition={{ duration: .4, ease: 'easeInOut' }}
          >
            <LogoContainer>
              <motion.svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 100 100"
                className="item"
              >
                <motion.path
                  d="m-7,30.747825l37.675862,0l0,-38.997825l38.648282,0l0,38.997825l37.675866,0l0,40.004365l-37.675866,0l0,38.997821l-38.648282,0l0,-38.997821l-37.675862,0l0,-40.004365z"
                  variants={icon}
                  initial="hidden"
                  animate="visible"
                  transition={{
                    default: { duration: 2, ease: "easeInOut" },
                    fill: { duration: 2, ease: [1, 0, 0.8, 1] }
                  }}
                />
              </motion.svg>
            </LogoContainer>
            <SplashTitle>iCare</SplashTitle>
          </motion.div>
        }
        <motion.div
          initial={{ opacity: 0, y: 10 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{
            ease: 'easeOut',
            delay: 3
          }}
        >
          <Card>
            <LoginContainer onSubmit={creatingAccount ? this.handleCreateAccount : this.handleLogin}>
            {
                creatingAccount && (
                  <React.Fragment>
                    <InputContainer>
                      <PersonIcon className="loginIcon" />
                      <BaseInput
                        className="loginInput"
                        type="text"
                        required
                        maxLength={80}
                        minLength={1}
                        placeholder="First Name"
                        value={firstName}
                        onChange={(evt) => this.setState({ firstName: evt.target.value })}
                      />
                    </InputContainer>
                    <InputContainer>
                      <PersonIcon className="loginIcon" />
                      <BaseInput
                        className="loginInput"
                        type="text"
                        required
                        maxLength={80}
                        minLength={1}
                        placeholder="Last Name"
                        value={lastName}
                        onChange={(evt) => this.setState({ lastName: evt.target.value })}
                      />
                    </InputContainer>
                  </React.Fragment>
                )
              }
              <InputContainer>
                <EmailIcon className="loginIcon" />
                <BaseInput
                  className="loginInput"
                  type="email"
                  required
                  maxLength={80}
                  placeholder="Email"
                  value={username}
                  onChange={(evt) => this.setState({ email: evt.target.value })}
                />
              </InputContainer>
              <InputContainer>
                <VPNKeyIcon className="loginIcon" />
                <BaseInput
                  className="loginInput"
                  type="password"
                  required
                  maxLength={80}
                  minLength={creatingAccount ? 8 : 1}
                  placeholder="Password"
                  value={password}
                  onChange={(evt) => this.setState({ password: evt.target.value })}
                  onKeyUp={(evt) => {
                    if (evt.keyCode === 13) creatingAccount ? this.handleSignUp() : this.handleLogin();
                  }}
                />
              </InputContainer>
              <Options>
                <Button
                  classes={{ root: classes.loginButton }}
                  color="primary"
                  variant="contained"
                  type="submit"
                >
                  {
                    creatingAccount ? 'Sign Up' : 'Login'
                  }
                </Button>
                <Button
                  color="default"
                  onClick={this.handleToggleLogin}
                >
                  {
                    creatingAccount ? 'Login' : 'Create Account'
                  }
                </Button>
              </Options>
            </LoginContainer>
          </Card>
        </motion.div>
      </Wrapper>
    );
  }
}

const styles = ({
  loginButton: {
    width: 150,
  },
});

const Wrapper = styled.div`
  display: flex;
  flex-flow: column;
  align-items: center;
  justify-content: center;
  width: 100%;
  padding-top: 7em;
`;

const LogoContainer = styled.div`
  width: 150px;
  height: 150px;
  display: flex;
  place-content: center;
  margin-top: 3em;
  overflow: hidden;
  background: rgba(33,150,243,.8);
  border-radius: 30px;
`;

const SplashTitle = styled.h3`
  text-align: center;
  color: white;
  font-weight: 300;
  font-size: 24px;
  margin: .5em 0;
`;

const LoginContainer = styled.form`
  margin: 16px;
  margin-top: 24px;
`;

const Options = styled.div`
  padding-top: 8px;
  display: flex;
  justify-content: space-between;
`;

const icon = {
  hidden: {
    opacity: 0,
    pathLength: 0,
    fill: "rgba(255, 255, 255, 0)"
  },
  visible: {
    opacity: 1,
    pathLength: 1,
    fill: "rgba(255, 255, 255, 1)"
  }
};

export default withStyles(styles)(Login);
