package com.github.pjfanning.jackson

import co.blocke.scala_reflection.RType

case object TestObject {
  val name = "test"
}

object ObjectMain extends App {
  val rObject = RType.of[TestObject.type]

  println(rObject) // fields - empty

  //val objectFields = TestObject.getClass.getField("MODULE$").getType.getFields.toSeq
  //val objectMethods = TestObject.productElementNames.toSeq
  println(com.fasterxml.jackson.module.scala.introspect.BeanIntrospector(TestObject.getClass).properties)
}
