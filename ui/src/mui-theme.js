import { createMuiTheme } from '@material-ui/core/styles';

const muiTheme = createMuiTheme({
  palette: {
    type: 'dark',
    primary: {
      main: '#2196F3'
    },
    secondary: {
      main: '#2dc469'
    }
  },
  background: {
    paper: 'rgb(57, 65, 70)',
    default: 'rgb(57, 65, 70)'
  },
  overrides: {
    MuiButton: {
      containedSecondary: {
        color: 'white',
      }
    },
    MuiPaper: {
      root: {
        background: 'rgb(57, 65, 70)',
      }
    },
    MuiSnackbar: {
      root: {
        background: 'rgb(67, 75, 80)',
      }
    }
  }
});

export default muiTheme;
