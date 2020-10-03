@file:Suppress("JAVA_MODULE_DOES_NOT_DEPEND_ON_MODULE")

package com.axetrading.game.cookingaxe.arena

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.platform.runner.JUnitPlatform
import org.junit.platform.suite.api.SelectClasses
import org.junit.runner.RunWith
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
@ExperimentalTime
@RunWith(JUnitPlatform::class)
@SelectClasses(MapInfoTest::class, WorldTest::class, BasicVector2dTest::class, BaseFigureTest::class, MoveHandlerTest::class, ArenaTest::class)
class BackendTests