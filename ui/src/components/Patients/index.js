import React, { Component } from 'react';
import styled from 'styled-components';
import Card from '@material-ui/core/Card';
import Text, {Title} from '../Text';

class Patients extends Component {
  render() {
    return (
      <Wrapper>
        <Title>Patients</Title>
        <Card>
          <CardBody>
            <Text>Hi</Text>
          </CardBody>
        </Card>
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


export default Patients;
