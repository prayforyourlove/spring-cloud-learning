
package com.dzsw.wqh.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Oilyy基础配置
 *
 */
@Configuration
@MapperScan(basePackages = "com.dzsw.wqh.mapper")
@Slf4j
public class DataSourceConfig
{

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;



	@Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
	@Primary
	public DataSource oilyyDataSource() {

		DruidDataSource datasource = new DruidDataSource();
		try {
			datasource.setUrl(url);
			datasource.setDriverClassName(driverClassName);
			datasource.setUsername(username);
			datasource.setPassword(password);
		} catch (Exception e) {
			log.error("数据库连接用户信息加解密错误:", e);
		}finally{
			datasource.close();
		}
		return datasource;
	}



	@Bean(name = "transactionManger")
	@Primary
	public DataSourceTransactionManager  oilyyTransactionManger(@Qualifier("dataSource") DataSource dataSource) {
		try {
			return new DataSourceTransactionManager(dataSource);
		} catch (Exception e) {
			log.error("配置transactionManager事物管理器错误:", e);
		}
		return null;
	}


	@Bean(name = "sqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) {
		try {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			bean.setTypeAliasesPackage("com.dzsw.wqh.model");
			org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
			configuration.setMapUnderscoreToCamelCase(true);
			configuration.setLazyLoadingEnabled(true);
			configuration.setAggressiveLazyLoading(false);
			bean.setConfiguration(configuration);
			// 指定mapper xml目录
			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			bean.setMapperLocations(resolver.getResources("classpath*:sqlmap/*Mapper.xml"));
			bean.setPlugins(new Interceptor[]{pageHelper()});
			return bean.getObject();
		} catch (Exception e) {
			log.error("创建sqlSessionFactory出错:", e);
		}
		return null;

	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	@Bean
	public PageHelper pageHelper(){
		//分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);
		return pageHelper;
	}

}