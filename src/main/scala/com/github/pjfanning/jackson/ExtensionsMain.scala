package com.github.pjfanning.jackson

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.github.pjfanning.jackson.reflection.ScalaReflectionExtensions

object ExtensionsMain extends App {
  //create mapper with ScalaReflectionExtensions mixin
  val mapper = JsonMapper.builder().addModule(DefaultScalaModule).build() :: ScalaReflectionExtensions
  //deserialization with Option[Long] usually generates an invalid Option[Long] but succeeds with this mixin
  //see https://github.com/FasterXML/jackson-module-scala/wiki/FAQ#deserializing-optionint-seqint-and-other-primitive-challenges
  val v1 = mapper.readValue[WrappedOptionLong]("""{"text":"myText","wrappedLong":{"valueLong":151}}""")
  println(v1)
  val valueLong = v1.wrappedLong.valueLong.get
  println(s"valueLong=$valueLong")
}
