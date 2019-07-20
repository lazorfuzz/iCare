import React, {Component} from 'react';
import {HorizontalBar} from 'react-chartjs-2';
import styled from 'styled-components';
import generateChartData from './util';

class CompareChart extends Component{

  constructor(props){
    super(props);

  }


  render() {
    const {data, options} = this.props;
    const styles = {
      backgroundColor: 'rgba(255,99,132,0.2)',
      borderColor: 'rgba(255,99,132,1)',
      borderWidth: 1,
      hoverBackgroundColor: 'rgba(255,99,132,0.4)',
      hoverBorderColor: 'rgba(255,99,132,1)',
    }
    return (
      <Wrapper>
        <HorizontalBar data={generateChartData(data.title, data.labels, data.values, styles)} height={400} width={800} options={options} />
      </Wrapper>
    );
  }
}

const Wrapper = styled.div`
  display: flex;
  flex-flow: column;
  margin: 0 auto;
  padding-top: 16px;
`;

export default CompareChart;
