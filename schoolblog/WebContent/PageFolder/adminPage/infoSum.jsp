<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<!--            账号管理 ----密码修改                              start       -->
			<div class="infoSum-Container col-lg-12 col-md-12 col-sm-12" style="display:none;">
				
				<div id="infoSum-container"  class="col-lg-12 col-md-12 col-sm-12">
					<div id="main" style="width: 600px;height:400px;margin-left: 20%"></div>
						<script type="text/javascript">
							var myChart;
							//综合图
							function zonghe(){
								var category = ['个人文章数','网站访问量','用户在线数'];
								var dottedBase = +new Date();
								var lineData = [];
								var barData = [];

								for (var i = 0; i < 3; i++) {
								    var b = Math.random() * 200;
								    var d = Math.random() * 200;
								    barData.push(b)
								    lineData.push(d + b);
								}

							
								// option
								var option = {
								    backgroundColor: '#fff',
								    tooltip: {
								        trigger: 'axis',
								        axisPointer: {
								            type: 'shadow',
								            label: {
								                show: true,
								                backgroundColor: '#333'
								            }
								            
								        }
								    },
								    legend: {
								        data: ['line', 'bar'],
								        textStyle: {
								            color: '#000000'
								        }
								    },
								    xAxis: {
								        data: category,
								        axisLine: {
								            lineStyle: {
								                color: '#000000'
								            }
								        }
								    },
								    yAxis: {
								        splitLine: {show: false},
								        axisLine: {
								            lineStyle: {
								                color: '#000000'
								            }
								        }
								    },
								    series: [{
								        name: 'line',
								        type: 'line',
								        smooth: true,
								        showAllSymbol: true,
								        symbol: 'emptyCircle',
								        symbolSize: 15,
								        data: lineData
								    }, {
								        name: 'bar',
								        type: 'bar',
								        barWidth: 10,
								        itemStyle: {
								            normal: {
								                barBorderRadius: 5,
								                color: new echarts.graphic.LinearGradient(
								                    0, 0, 0, 1,
								                    [
								                        {offset: 0, color: '#14c8d4'},
								                        {offset: 1, color: '#43eec6'}
								                    ]
								                )
								            }
								        },
								        data: barData
								    }, {
								        name: 'line',
								        type: 'bar',
								        barGap: '-100%',
								        barWidth: 10,
								        itemStyle: {
								            normal: {
								                color: new echarts.graphic.LinearGradient(
								                    0, 0, 0, 1,
								                    [
								                        {offset: 0, color: 'rgba(20,200,212,0.5)'},
								                        {offset: 0.2, color: 'rgba(20,200,212,0.2)'},
								                        {offset: 1, color: 'rgba(20,200,212,0)'}
								                    ]
								                )
								            }
								        },
								        z: -12,
								        data: lineData
								    }, {
								        name: 'dotted',
								        type: 'pictorialBar',
								        symbol: 'rect',
								        itemStyle: {
								            normal: {
								                color: '#0f375f'
								            }
								        },
								        symbolRepeat: true,
								        symbolSize: [12, 4],
								        symbolMargin: 1,
								        z: -10,
								        data: lineData
								    }]
								};
								
							}
							
					        //折线图
							function zhexian(){
								// 指定图表的配置项和数据
								myChart = echarts.init(document.getElementById('main'));
								var option = {
										title: {
							                text: '数据展示'
							            },
							            tooltip: {},
							            legend: {
							                data:['数量']
							            },
									    xAxis: {
									        type: 'category',
									        data: ["个人文章数","网站访问量","用户在线数"]},
									    yAxis: {
									        type: 'value'
									    },
									    series: [{
									    	name: '数量',
									    	data: ['${releaseNum}','${historypeople}','${onlinepeople}'],
									        type: 'line'
									    }]
									};

						    	// 使用刚指定的配置项和数据显示图表。
						    	myChart.clear();
						        myChart.setOption(option);
							}
							//柱状图
							function zhuzhuang(){
								// 指定图表的配置项和数据
								myChart = echarts.init(document.getElementById('main'));
								var option = {
						            title: {
						                text: '数据展示'
						            },
						            tooltip: {},
						            legend: {
						                data:['数量']
						            },
						            xAxis: {
						                data: ["个人文章数","网站访问量","用户在线数"]
						            },
						            yAxis: {},
						            series: [{
						                name: '数量',
						                type: 'bar',
						                data: ['${releaseNum}','${historypeople}','${onlinepeople}']
						            }]
						        };
						    	// 使用刚指定的配置项和数据显示图表。
						    	
						    	myChart.clear();
						        myChart.setOption(option);
							}
							//圆饼图
							function yuanbing(){
								// 指定图表的配置项和数据
								myChart = echarts.init(document.getElementById('main'));
								var option = {
									    backgroundColor: '#FFFFFF',
									    title: {
									        text: '数据展示',
									        left: 'left',
									        top: 20,
									        textStyle: {
									            color: '#100F0F'
									        }
									    },
									    series : [
									        {
									            name:'访问来源',
									            type:'pie',
									            radius : '55%',
									            center: ['50%', '50%'],
									            data:[
									                {value:'${releaseNum}', name:'个人文章数'},
									                {value:'${historypeople}', name:'网站访问量'},
									                {value:'${onlinepeople}', name:'用户在线数'}
									            ].sort(function (a, b) { return a.value - b.value; }),
									            roseType: 'radius',
									           
									            labelLine: {
									                normal: {
									                    lineStyle: {
									                        color: 'rgba(20, 20, 255, 0.3)'
									                    },
									                    smooth: 0.2,
									                    length: 10,
									                    length2: 20
									                }
									            },
									            animationType: 'scale',
									            animationEasing: 'elasticOut',
									            animationDelay: function (idx) {
									                return Math.random() * 200;
									            }
									        }
									    ]
									};
						    	// 使用刚指定的配置项和数据显示图表。
						    	myChart.clear();
						        myChart.setOption(option);
							}
					        
    					</script>
						<button  style="float:left;margin-left: 35%;" class="zhexian btn btn-default" onclick="zhexian()">折线图</button>
   						<button  style="float:left;" class="zhuzhuang btn btn-default" onclick="zhuzhuang()">柱状图</button>
   						<button  class="yuanbing btn btn-default" onclick="yuanbing()">圆饼图</button>
   			
				</div>
			</div>
			
			<!--            账号管理 ----密码修改                              end       -->