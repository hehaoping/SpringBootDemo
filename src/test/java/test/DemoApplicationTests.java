package test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.naruto.Boot;
import com.naruto.platform.util.CustomJpaUtil;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年1月28日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Boot.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@EnableAutoConfiguration
public class DemoApplicationTests {

	@Autowired
	private CustomJpaUtil customJpaUtil;

	@Autowired
	private Environment env;

	@Test
	public void testCustomJpaUtil() {
		String sql = "select t.name as teacherName,s.name as schoolName from teacher t left join school s on t.schoolID=s.id where s.id=?1";
		List<Map<String, Object>> list = customJpaUtil.queryListBySQL(sql, 2);
		System.out.println(list);
	}

	public void testEnvironment() {
		String[] defaultProfiles = env.getDefaultProfiles();
		for (String s : defaultProfiles) {
			System.out.println(s);
		}
		System.out.println(env.getProperty("spring.datasource.url"));
	}

}
