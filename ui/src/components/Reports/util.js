import jstat from 'jstat';

function generateChartData(chartName, labels, data, styles) {
  const chartData = {
    labels,
    datasets: [
      {
        label: chartName,
        ...styles,
        data
      }
    ]
  };
  return chartData;
}

function calculatePercentile(input, avg, std){
  const zScore = jstat.zscore(input, avg, std);
  const pValue = jstat.ztest(zScore, 1);
  return pValue;

}

export { generateChartData, calculatePercentile };
