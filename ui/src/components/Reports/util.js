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
  return 80;

}

export default generateChartData;
