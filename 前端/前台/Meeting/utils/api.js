import {getApi,postApi } from './http';
 
 
export const getBanner = () => getApi("");  
 
export const getProduct = (data) => getApi("/product/",data);  
 
export const getDetail = (id) => getApi(`/product/${id}/`)
 
export const postLogin = (params) => postApi("/my_user/login/",params)
