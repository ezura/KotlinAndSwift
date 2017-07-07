### Swift と Kotlin、異文化旅行
2017/7/8   
\#yidev  
ezura

---

### "\self"
* ezura
* iOS engineer @ LINE

---

Kotlin

+++

Android で公式にサポート  
ちょっと気になる存在…

+++

Swift と Kotlin

+++

似てるの？？
都市伝説？？

+++

確かに、構文が似てる部分もある
<aside>初めて見たときも親しみやすかった印象</aside>

+++

* 静的型付け
* Null safe
* interface の default implement
* ...

+++

似てそう？？  
でも…

+++

~~一歩進むたびに~~  
もはや足をあげるところから  
違いに出会う世界 😇  
(構文というより、設計の面で…)

+++

今回は、その体験を味わいながら  
進められたら良いなと思います 😊

---

### index
* Kotlin はどんな言語？
* 具体的な違い (数種)
  * Type hierarchy
  * ~~Value type~~
  * Variant
  * Singleton
* 上記の盛り合わせ + α
* おまけ

---

### Kotlin
* 静的型付け
* null safe
* Java と 100% 互換
* オブジェクト指向
* 関数プログラミング

+++

### Kotlin
* 静的型付け
* null safe
* Java と 100% 互換
* **オブジェクト指向**
* 関数プログラミング

+++

Swift よりもオブジェクト指向寄りな設計がところどころで見えるような…？  
(注: 私見)

+++

### 演算子
##### Swift
```swift:Swift
func +(r: Type, l: Type) -> Type { ... }
```

##### Kotlin
```kotlin:Kotlin
class Type {
    operator fun plus(v: Type): Type { ... }
}
```

+++

### 型変換
##### Swift
```swift:Swift
class Destination {
    init(_ value: Source) { ... }
}
let v = Destination(source)
```

##### Kotlin
```kotlin:Kotlin
class Source {
    fun toDestination: Destination { ... }
}
val v = source.toDestination()
```
<aside>余談: Kotlin は extension で constructor を作れない)</aside>

+++
#### 超余談
```kotlin
fun Destination(v: Source): Destination {
    ...
}
let v = Destination(source)
```
<aside>こういう方法もあるらしい…</aside>

---

### 具体的な違い
  * Type hierarchy
  * ~~Value type~~
  * Variant
  * Singleton

+++

#### Type hierarchy
---?image=assets/images/TypeHierarchy.png&size=auto 90%

#### とても良かった記事
* [JavaプログラマのためのKotlin入門](http://qiita.com/koher/items/bcc58c01c6ff2ece658f)
* [Android開発を受注したからKotlinをガッツリ使ってみたら最高だった](http://qiita.com/omochimetaru/items/98e015b0b694dd97f323)
