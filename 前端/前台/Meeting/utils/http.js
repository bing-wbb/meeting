const baseURL = "http://localhost:8090"
 
/**
 * 对于网络请求，设置参数默认值
 */
const DEFAULT_REQUEST_OPTIONS = {
  baseURL,
  timeout:1000*5,
	header: { 
    "Content-Type": "application/json",
    // 'x-token': 'x-token'  // token 看自己是否需要
  },
}
 
/**
 * 请求的封装
 * @param {String} url 请求的接口地址
 * @param {String} method 请求的方法
 * @param {Object} data 请求的参数
 * @param {Object} option 请求头的配置
 */
const request = (url, method='GET', data={}, option={}) => {
 
  wx.showLoading({
    title: '加载中...',
  });
 
  // 合并配置，在配置信息中提取需要的部分
  let { baseURL, header} = Object.assign({}, DEFAULT_REQUEST_OPTIONS, option)
  return new Promise((resolve, reject) => {
    wx.request({
      url: baseURL + url,
      data,
      header,
      method,
      success: res => {
        // console.log('响应：',res);
        wx.hideLoading()
        if (res.statusCode === 200) {
          //200: 服务端业务处理正常结束
          resolve(res.data)
        } else {
          //其它错误，提示用户错误信息
          console.error(res);
          resolve(res)
          if(res.statusCode == 404){
            wx.showToast({
              title: '数据不存在',
              icon:'none'
            })
          }
        }
      },
      fail: res => {
        console.error(res);
        wx.hideLoading()
        reject(res)
      }
    })
  })
}
 
 
 
/**
 * GET请求
 * @param {String} url 请求接口地址
 * @param {Object} data 请求参数
 * @param {Object} option 请求头的配置
 */
export const getApi = (url, data, option) => request(url, 'GET', data, option);
 
/**
 * POST请求
 * @param {String} url 请求接口地址
 * @param {Object} data 请求参数
 * @param {Object} option 请求头的配置
 */
export const postApi = (url, data, option) => request(url, 'POST', data, option);
