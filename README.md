# 一个炒鸡敢单的爬虫Demo
使用爬虫技术中最基础的技术来实现，学会了它们的使用，也就能对市面上诸多爬虫框架的使用有更深入的理解。
## 技术使用以及简要介绍
+ **SSM**：项目整体使用的SSM的框架作为基础，但推荐使用Springboot来实现(更轻量、更简洁、项目搭建更快)。
+ **HttpClient**：Apache出品，Java协议客户端，用于模仿浏览器访问指定URL的过程。
+ **Jsoup**：通过HttpClient获取到了成功的响应后，使用Jsoup来作为解析返回的响应体内容，即解析返回的网页内容，并利用Jsoup实现
的类似Html的选择器来定位获取、提取指定标签中的内容，从而实现爬虫。
