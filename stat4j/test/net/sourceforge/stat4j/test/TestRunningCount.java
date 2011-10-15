/*
 *	Copyright 2005 stat4j.org
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package net.sourceforge.stat4j.test;

import java.net.URL;

import junit.framework.TestCase;

import net.sourceforge.stat4j.filter.MetricCollector;

import org.apache.log4j.Category;
import org.apache.log4j.PropertyConfigurator;


/**
 * Name:		TestUserCount.java
 * Date:		Sep 4, 2004
 * Description:
 * 
 * 
 * @author Lara D'Abreo
 */
public class TestRunningCount extends TestCase {

	public Category category;

	public TestRunningCount() {

	}

	public TestRunningCount(String arg0) {
		super(arg0);

		URL url = TestRunningCount.class.getResource("log.properties");
		PropertyConfigurator.configure(url);
		category = Category.getInstance("test");

	}

	public void testUserCount() {
		MetricCollector.getInstance().reset();
		int count = 0;
		int max = 0;

		String login = "Test user login.";
		String logout = "Test user logout.";

		for (int i = 0; i < 1000; ++i) {
			double d = Math.random() * 1000;
			if (d < 500) {
				++count;
				category.info(login);

			} else {
				--count;
				category.info(logout);
			}
			if (count > max) {
				max = count;
			}
			pause();
		} //rof
		System.out.println(">>> Number of users=" + count);
		System.out.println(">>> Max number of users=" + max);
		MetricCollector.getInstance().report(System.out);
	}

	public void testMaxUserCount() {
		MetricCollector.getInstance().reset();
		int count = 0;
		int max = 0;

		String login = "Test user login.";
		String logout = "Test user logout.";

		for (int i = 0; i < 1000; ++i) {
			double d = Math.random() * 1000;
			if (d < 500) {
				++count;
				category.info(login);

			} else {
				--count;
				category.info(logout);
			}
			if (count > max) {
				max = count;
			}
			pause();
		} //rof
		System.out.println(">>> Number of users=" + count);
		System.out.println(">>> Max number of users=" + max);
		MetricCollector.getInstance().report(System.out);
	}
	
	public void pause() {
		try {
			Thread.sleep((long)(Math.random() * 10));
		}catch (Exception e){}
	
	}

}
