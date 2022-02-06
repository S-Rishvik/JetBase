package com.example.data.util

interface Mapper<in FROM, out TO> {
  fun map(input: FROM): TO
}