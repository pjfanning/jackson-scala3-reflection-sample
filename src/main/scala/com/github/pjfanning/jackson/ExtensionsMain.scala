package com.github.pjfanning.jackson

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.github.pjfanning.jackson.reflection.ScalaReflectionExtensions

object ExtensionsMain extends App {
  //create mapper with ScalaReflectionExtensions mixin
  val mapper = JsonMapper.builder().addModule(DefaultScalaModule).build() :: ScalaReflectionExtensions
  //deserialization with Option[Long] usually fails but succeeds with this mixin
  val v1 = mapper.readValue[WrappedOptionLong]("""{"text":"myText","wrappedLong":{"valueLong":151}}""")
  println(v1)
}
