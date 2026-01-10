## 2章


### 2.2.3節
exampleパッケージをコンパイルする。
```bash
kotlinc geometry/**/*.kt -include-runtime -d example.jar
```

JARファイルを実行する
```bash
java -jar example.jar
```

### 2.3.1節
colorパッケージをコンパイルする。
```bash
kotlinc colors/**/*.kt -include-runtime -d color.jar
```

JARファイルを実行する
```bash
java -jar color.jar
```