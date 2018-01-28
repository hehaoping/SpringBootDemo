package com.naruto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.naruto.platform.repo.base.BaseRepositoryFactoryBean;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月14日
 */
// 指定自己的工厂类
@EnableJpaRepositories(basePackages = { "com.naruto.platform" }, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)

@SpringBootApplication
public class Boot {

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

}
