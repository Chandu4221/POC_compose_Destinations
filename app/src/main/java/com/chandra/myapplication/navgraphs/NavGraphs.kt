package com.chandra.myapplication.navgraphs

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@NavGraph
annotation class MainNavGraph(
    val start:Boolean = false
)