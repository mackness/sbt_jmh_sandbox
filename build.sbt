import Dependencies._

ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.valid"
ThisBuild / organizationName := "valid"

lazy val root = (project in file("."))
  .settings(
    name := "benchmarks",
    libraryDependencies += munit % Test
  )

enablePlugins(JmhPlugin)
