import React, {Component} from 'react';
import {Line} from 'react-chartjs-2';
import styled from 'styled-components';
import { withTheme } from '@material-ui/core/styles';
import { generateChartData } from './util';

class LineChart extends Component{
  render() {
    const {data, options, theme} = this.props;
    const accentColor = theme.palette.primary;
    const styles = {
      backgroundColor: accentColor.main,
      borderColor: accentColor.light,
      borderWidth: 1,
      hoverBackgroundColor: accentColor.dark,
      hoverBorderColor: accentColor.main,
    }
    return (
      <Wrapper>
        <Line data={generateChartData(data.title, data.labels, data.values, styles)} height={400} width={800} options={options} />
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

export default withTheme()(LineChart);



const data = {
  labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
  datasets: [
    {
      label: 'My First dataset',
      fill: false,
      lineTension: 0.1,
      backgroundColor: 'rgba(75,192,192,0.4)',
      borderColor: 'rgba(75,192,192,1)',
      borderCapStyle: 'butt',
      borderDash: [],
      borderDashOffset: 0.0,
      borderJoinStyle: 'miter',
      pointBorderColor: 'rgba(75,192,192,1)',
      pointBackgroundColor: '#fff',
      pointBorderWidth: 1,
      pointHoverRadius: 5,
      pointHoverBackgroundColor: 'rgba(75,192,192,1)',
      pointHoverBorderColor: 'rgba(220,220,220,1)',
      pointHoverBorderWidth: 2,
      pointRadius: 1,
      pointHitRadius: 10,
      data: [65, 59, 80, 81, 56, 55, 40]
    }
  ]
};
