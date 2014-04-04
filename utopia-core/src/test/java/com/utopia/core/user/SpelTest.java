package com.utopia.core.user;

import java.util.Date;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.utopia.core.model.CoUser;

public class SpelTest {

	@Test
	public void parse(){
		CoUser user=new CoUser();
		user.setUsername("admin");
		String logic="username==null OR 1==1";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(logic);
		EvaluationContext context = new StandardEvaluationContext(user);
		context.setVariable("", new Date());
		exp.getValue(context);
		System.out.println(exp);
	}
}
