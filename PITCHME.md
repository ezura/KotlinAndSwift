### Swift と Kotlin 異文化旅行
2017/7/8   
\#yidev  
ezura

---

### \\(self)
* ezura
* iOS engineer @ LINE
* 話したいことがあり過ぎて発散して資料が着地できなかったので、iosdc 応募ネタの一部のその一部を発表します

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
* 型推論
* Null safe
* interface が default implement を持てる
* Object 指向
* 関数プログラミング
* Generics
* ...

+++

似てそう？？  
でも…

+++

~~一歩進むたびに~~  
もはや足をあげるところから  
違いに出会う世界 😇  
(設計の面で…)

+++

今回は、その体験を味わいながら  
進められたら良いなと思います 😊

---

### index
* Kotlin はどんな言語？
* 標準ライブラリ 有名観光地ツアー
  * Type hierarchy
  * Top Type: class Any
  * Variant
  * Singleton

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

### 標準ライブラリ 有名観光地ツアー

+++

### List
<aside>Kotlin にも Array はあるけれど  
機能的には List の方が Swift の Array に近い部分が多い。</aside>
<aside>List の方がポピュラー</aside>

+++

```kotlin
val list = listOf(1, 2, 3)
```

+++

```kotlin
val list: List<Int> = listOf(1, 2, 3)
```
@[1](`listOf` を見てみよう)

+++?code=assets/codes/listOf.kt
<aside>注: スライド上での見やすさのため、整形しています</aside>

+++?code=assets/codes/listOf.kt
@[6](emptyList...?)

+++

```kotlin
/** Returns an empty read-only list.  The returned list is serializable (JVM). */
public fun <T> emptyList(): List<T> = EmptyList
```

+++

```kotlin
object EmptyList : List<Nothing>, Serializable, RandomAccess {
// 略
}
```
@[1](`object`...?)

+++

### `Object`
* Singleton
* constractor が指定できない以外、class と同様の機能

+++

```kotlin
object EmptyList : List<Nothing>, Serializable, RandomAccess {
// 略
}
```
@[1](`List<Nothing>`)

+++

Swift の Array と同様、  
型パラメータの部分は要素と予想できる

+++?code=assets/codes/list.kt
@[6](`out`...?)

+++

### Variance annotation

+++

### Variance
* invariance
* covariance
* contravariance

+++

### invariance

`Any` <- `Int`  
のとき  
`MyBox<Any>` ~~<-~~ `MyBox<Int>`

<aside>Swift は基本的にはこれ (Array, Optional 等、一部の型以外)</aside>
<aside>ただし、`intout` 指定のときは `Array` も invariance になる</aside>
<aside>(Kotlin の　Array は要素に対して不変)</aside>

+++

### covariance の例

`Any` <- `Int`  
のとき  
`Array<Any>` <- `Array<Int>`
<aside>Swift の Array</aside>

+++

```

### contravariance の例

`Any` <- `Int`  
のとき  
`(Int) -> T` <- `(Any) -> T`

+++

### out, in

```swift
let outF: () -> Any = { () -> Int in return 1 }
let inF: (Int) -> Void = { (v: Any) -> Void in print(v) }
```
@[1](out)
@[2](in)

+++

* Swift だと、暗黙的に提供されているもののみ適応
* Kotlin だと指定できる！

+++

### ちょっと余談
Swift でも、Variance 指定、垣間見える場合がある
```swift
func f(_ v: Array<Any>) {}
func inoutF(_ v: inout Array<Any>) {}

var v: Array<Int> = [1, 2, 3]
f(v)  // OK
// error: cannot convert value of type 'Array<Int>' to expected argument type 'inout Array<Any>'
inoutF(v)  // error
```
@[2]

---

### 具体的な違い
  * Type hierarchy
  * ~~Value type~~
  * Variant
  * Singleton

+++

#### Type hierarchy

![Type hierarchy](assets/images/TypeHierarchy.png)

+++

#### Type hierarchy

![Type hierarchy](assets/images/TypeHierarchy2.png)

+++

* Any: 全ての型の super type
* Nothing: 全ての型の sub type

+++

### Any
* kotlin
  - class
* Swift
  - 空の protocol (-> Non-nominal type)
  
+++

Any は
* 全ての型の super type
* **class**

---

### Singleton

+++

Singleton を言語の機能で提供

+++

```kotlin
object Type { ... }
```



---

いくつかの違い

---

### とても参考になったサイト・記事
* [Kotlin Reference](https://kotlinlang.org/docs/reference/)
* [JavaプログラマのためのKotlin入門](http://qiita.com/koher/items/bcc58c01c6ff2ece658f)
* [Android開発を受注したからKotlinをガッツリ使ってみたら最高だった](http://qiita.com/omochimetaru/items/98e015b0b694dd97f323)
