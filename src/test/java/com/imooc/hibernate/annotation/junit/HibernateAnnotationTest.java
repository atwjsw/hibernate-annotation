package com.imooc.hibernate.annotation.junit;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.imooc.hibernate.annotation.attr.Student;
import com.imooc.hibernate.annotation.attr.StudentPK;
import com.imooc.hibernate.annotation.attr.StudentWithCompositeKey;
import com.imooc.hibernate.annotation.clazz.Address;
import com.imooc.hibernate.annotation.m2m.StudentM2M;
import com.imooc.hibernate.annotation.m2m.TeacherM2M;
import com.imooc.hibernate.annotation.m2o.ClassRoom;
import com.imooc.hibernate.annotation.m2o.StudentM2O;
import com.imooc.hibernate.annotation.o2m.ClassRoomO2M;
import com.imooc.hibernate.annotation.o2m.StudentO2M;
import com.imooc.hibernate.annotation.o2o.IDCard;
import com.imooc.hibernate.annotation.o2o.StudentO2O;
import com.imooc.hibernate.annotation.o2obd.IDCardBD;
import com.imooc.hibernate.annotation.o2obd.StudentO2OBD;
import com.imooc.hibernate.util.HibernateUtil;

public class HibernateAnnotationTest {
	
	/*
	 * 测试通过注解的持久类生成数据库结构。
	 * 需要修改hibernate.cfg.xml来配置映射参考类
	 */
	@Test
	public void testSchemaExport() {
		
		Configuration config = new Configuration().configure();
		//SessionFactory sessionFactory = config.buildSessionFactory();
		
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);		
	}	
	
	/*
	 * 测试插入手工设置主键值的学生记录
	 */
	@Test
	public void testAddStudent() {		
			
			Session session = HibernateUtil.getSession();
			
			Address add = new Address("510080", "13988889899", "湖北武当山");
					
			Student student = new Student("S0000001", "张三丰", "男", new Date(), "太极拳", add);
			
			Transaction tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			
			HibernateUtil.closeSession(session);		
		
	};	
	
	/*
	 * 测试插入组合主键的学生记录
	 */
	@Test
	public void testAddStudentWithCompositeKey() {		
			
			Session session = HibernateUtil.getSession();
			
			Address add = new Address("510080", "13988889899", "湖北武当山");
			
			StudentPK pk = new StudentPK("123456789012345678", "S0000001");
			
			StudentWithCompositeKey stu = 
					new StudentWithCompositeKey(pk,  "张三丰", "男", new Date(), "太极拳", add);
					
			Transaction tx = session.beginTransaction();
			session.save(stu);
			tx.commit();
			
			HibernateUtil.closeSession(session);		
	};	
	
	/*
	 * 测试插入一对一关系的学生记录和身份证记录
	 */
	@Test
	public void testAddStudentO2O() {		
			
			Session session = HibernateUtil.getSession();
			
			IDCard id = new IDCard("123456789012345678", "张无忌");					
			StudentO2O stuO2O = new StudentO2O("男", new Date(), "太极拳", id);
			
			Transaction tx = session.beginTransaction();
			
			//注意：虽然配置了cascade，还是需要分别save, 原因待查
			session.save(id);
			session.save(stuO2O);
			tx.commit();
			
			HibernateUtil.closeSession(session);		
		
	};	
	
	/*
	 * 测试插入一对一关系的学生记录和身份证记录
	 */
	@Test
	public void testAddStudentO2OBD() {		
			
			Session session = HibernateUtil.getSession();
			
			IDCardBD id = new IDCardBD("123456789012345678", "张无忌");					
			StudentO2OBD stuO2O = new StudentO2OBD("男", new Date(), "太极拳", id);
			id.setStudent(stuO2O);
			
			Transaction tx = session.beginTransaction();
			
			session.save(id);
			session.save(stuO2O);
			tx.commit();
			
			HibernateUtil.closeSession(session);		
		
	};	
	
	/*
	 * 测试插入单向多对一关系的学生记录和班级记录
	 */
	@Test
	public void testAddStudentM2O() {		
			
			Session session = HibernateUtil.getSession();
			
			ClassRoom cr1 = new ClassRoom("c011", "一年一班");
			ClassRoom cr2 = new ClassRoom("c032", "三年二班");
			ClassRoom cr3 = new ClassRoom("c054", "五年四班");
			
			StudentM2O stu1 = new StudentM2O("张三丰", "男", new Date(), "太极拳", cr1);
			StudentM2O stu2 = new StudentM2O("张无忌",  "男", new Date(), "太极拳", cr1);
			StudentM2O stu3 = new StudentM2O("慕女神",  "女", new Date(), "慕课网主", cr2);
			StudentM2O stu4 = new StudentM2O("小慕慕",  "男", new Date(), "慕课网学生", cr2);
			StudentM2O stu5 = new StudentM2O("无名氏",  "男", new Date(), "无专业", new ClassRoom());
			
			Transaction tx = session.beginTransaction();
			
			session.save(cr1);
			session.save(cr2);
			session.save(stu1);
			session.save(stu2);
			session.save(stu3);
			session.save(stu4);
			tx.commit();
			
			HibernateUtil.closeSession(session);		
		
	};	
	
	/*
	 * 测试插入单向一对多关系的班级记录和学生记录
	 */
	@Test
	public void testAddClassRoomO2M() {		
			
			Session session = HibernateUtil.getSession();
			
			ClassRoomO2M cr1 = new ClassRoomO2M("c011", "一年一班");
			ClassRoomO2M cr2 = new ClassRoomO2M("c032", "三年二班");
			ClassRoomO2M cr3 = new ClassRoomO2M("c054", "五年四班");
			
			StudentO2M stu1 = new StudentO2M("张三丰", "男", new Date(), "太极拳");
			StudentO2M stu2 = new StudentO2M("张无忌",  "男", new Date(), "太极拳");
			StudentO2M stu3 = new StudentO2M("慕女神",  "女", new Date(), "慕课网主");
			StudentO2M stu4 = new StudentO2M("小慕慕",  "男", new Date(), "慕课网学生");
			StudentO2M stu5 = new StudentO2M("无名氏",  "男", new Date(), "无专业");
			
			Transaction tx = session.beginTransaction();
			
			cr1.getStudents().add(stu1);
			cr1.getStudents().add(stu2);
			cr2.getStudents().add(stu3);
			cr2.getStudents().add(stu4);
			
			session.save(cr1);
			session.save(cr2);
			
			/*session.save(cr1);
			session.save(cr2);
			session.save(stu1);
			session.save(stu2);
			session.save(stu3);
			session.save(stu4);*/
			tx.commit();
			
			HibernateUtil.closeSession(session);		
		
	};	
	
	/*
	 * 测试插入单向多对多关系的班级记录和学生记录
	 */	
	@Test
	public void testAddStudentM2M() {		
			
			Session session = HibernateUtil.getSession();
			
			TeacherM2M t1 = new TeacherM2M("T001", "慕老师");
			TeacherM2M t2 = new TeacherM2M("T002", "课老师");
			TeacherM2M t3 = new TeacherM2M("T003", "网老师");
					
						
			StudentM2M stu1 = new StudentM2M("张三丰", "男", new Date(), "太极拳");
			StudentM2M stu2 = new StudentM2M("张无忌",  "男", new Date(), "太极拳");
			StudentM2M stu3 = new StudentM2M("慕女神",  "女", new Date(), "慕课网主");
			StudentM2M stu4 = new StudentM2M("小慕慕",  "男", new Date(), "慕课网学生");
			StudentM2M stu5 = new StudentM2M("无名氏",  "男", new Date(), "无专业");
			
			Transaction tx = session.beginTransaction();
			
			stu1.getTeachers().add(t1);
			stu1.getTeachers().add(t2);
			stu1.getTeachers().add(t3);
			
			stu2.getTeachers().add(t1);
			stu2.getTeachers().add(t2);
			
			stu3.getTeachers().add(t2);
			stu3.getTeachers().add(t3);
			
			stu4.getTeachers().add(t3);
			
			session.save(t1);
			session.save(t2);
			session.save(t3);
			session.save(stu1);
			session.save(stu2);
			session.save(stu3);
			session.save(stu4);			
			tx.commit();
			
			HibernateUtil.closeSession(session);		
		
	};	

}
