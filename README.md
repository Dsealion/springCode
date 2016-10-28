#Spring框架学习
记录学习代码

##1.Spring基本功能详解

 **SpringIOC**：Spring的控制反转：把对象的创建、初始化、销毁等工作交给spring容器来做。由spring容器控制对象的生命周期。多例模式下不负责销毁




> **总结 spring的IOC**：

  IOC:spring容器控制对象的生命周期：前提条件：在spring容器中的bean必须是单例的

*  创建

	* 方式

			利用默认的构造函数，如果没有默认的构造函数，会报错
			利用静态工厂方法
			利用实例工厂方法

	* 时机

			* lazy-init为“default/false”当启动spring容器的时候创建bean
				但是如果该bean是prototype时，特殊。这种情况无效
				优点：在spring容器启动的时候，就会发现错误
				缺点：有可能会造成一些数据长时间驻留在内存中

			* lazy-init为"true"当context.getBean时创建
				bean为多例时，必须用这种方案创建对象
				缺点：不能及时发现错误
				优点：数据会在需要的时候加载
	* 初始化


			由spring容器调用init方法
			在构造函数之后执行

	* 销毁

			如果是单例，则必须返回ClassPathXmlApplicationContext该容器，才能执行销毁工作
			如果是多例，容器不负责销毁
		



	