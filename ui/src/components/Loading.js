import React, { PureComponent } from 'react';
import styled from 'styled-components';
import CircularProgress from '@material-ui/core/CircularProgress';

class Loading extends PureComponent {
  render() {
    const { loadingText } = this.props
    return (
      <LoadingContainer className="animated fadeIn">
        <CircularProgress color="secondary" />
        { loadingText ? <LoadingText>{loadingText}</LoadingText> : null }
      </LoadingContainer>
    );
  }
}

const LoadingContainer = styled.div`
  display: flex;
  flex-flow: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  margin: auto;
`;

const LoadingText = styled.p`
  color: rgba(255, 255, 255, .2);
  text-align: center;
  margin-top: 1em;
`;

export default Loading;
