package com.github.pjfanning.jackson

import co.blocke.scala_reflection.RType
import co.blocke.scala_reflection.info.ClassInfo
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.github.pjfanning.jackson.reflection.ScalaReflectionExtensions

object RTypeMain extends App {
  // because the co.blocke/scala-reflection compiler plugin is enabled, the rtype is evaluated at compile time
  val rtype = RType.of[WrappedOptionLong]
  // this ScalaReflectionExtensions call will configure jackson-module-scala with the correct type info for WrappedOptionLong
  ScalaReflectionExtensions.registerInnerTypes(rtype)
  val mapper = JsonMapper.builder().addModule(DefaultScalaModule).build()
  // the following readValue would fail without the registerInnerTypes call above
  val v1 = mapper.readValue("""{"text":"myText","wrappedLong":{"valueLong":151}}""", classOf[WrappedOptionLong])
  println(v1)
}
