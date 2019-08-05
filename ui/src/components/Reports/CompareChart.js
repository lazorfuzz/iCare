import React, {Component} from 'react';
import {HorizontalBar} from 'react-chartjs-2';
import styled from 'styled-components';
import { withTheme } from '@material-ui/core/styles';
import { generateChartData } from './util';

class CompareChart extends Component{
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
        <HorizontalBar
          data={generateChartData(data.title, data.labels, data.values, styles)}
          height={200}
          width={800}
          options={options}
        />
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

export default withTheme(CompareChart);
