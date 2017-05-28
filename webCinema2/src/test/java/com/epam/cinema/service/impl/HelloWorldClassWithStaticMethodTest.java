package com.epam.cinema.service.impl;

import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HelloWorldClassWithStaticMethod.class)
public class HelloWorldClassWithStaticMethodTest {

	@Test
	public void test() {
		PowerMockito.mockStatic(HelloWorldClassWithStaticMethod.class);
		final String mockedResult = "Hello!";
		when(HelloWorldClassWithStaticMethod.getString()).thenReturn(mockedResult);
		assertEquals(HelloWorldClassWithStaticMethod.getString(), mockedResult);
	}
}
