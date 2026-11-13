# ▶️ YouTube Backend API

Java 17 / Spring Boot を使用して開発した、動画共有サービスを想定したバックエンドAPIプロジェクトです。

ユーザー登録・ログイン、メールアドレス認証、JWTによる認証、プロフィール管理、ファイルアップロードなどの機能を中心に実装しています。また、動画・チャンネル・カテゴリー・タグに関するエンティティやDTOを定義し、動画登録APIの実装にも取り組みました。

本プロジェクトは、IT Academyでチーム開発として取り組んだ学習プロジェクトです。チームでの開発を通じて、Spring Bootを利用したREST APIの構成、データベース連携、認証処理などを学びました。

> **実装状況について：** 本READMEはリポジトリ内のソースコードを確認できた範囲で作成しています。プロジェクト全体の構想に含まれていても、ソースコード上で実装完了を確認できない機能は、完成機能として記載していません。

---

## 📋 1. プロジェクト概要

| 項目 | 内容 |
|---|---|
| プロジェクト名 | YouTube Backend API |
| 開発形態 | IT Academyでのチーム開発 |
| アプリケーション形式 | REST API |
| フレームワーク | Spring Boot 3.0.0 |
| プログラミング言語 | Java 17 |
| データベース | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| ビルドツール | Maven |

## ✨ 2. 主な機能・実装内容

### 🔐 認証・ユーザー登録（Authentication）

- メールアドレスとパスワードによるログインAPI
- ユーザー登録API
- メールによるアカウント有効化処理
- JWTの発行およびリクエスト時のトークン検証
- Spring Securityを利用した認証・アクセス制御の設定

### 👤 プロフィール管理（Profile）

- プロフィール情報の作成・更新処理
- パスワード変更処理
- メールアドレス変更処理
- ユーザーのロールおよびステータス管理

※プロフィール関連のすべての処理が完成・正常動作することを保証するものではありません。実装状況は各ServiceおよびControllerのコードに基づいています。

### 📎 ファイル管理（Attachment）

- ファイルアップロードAPI
- アップロードファイルの保存
- ファイル情報のデータベース登録
- 画像表示用API
- ファイルダウンロードAPI
- ファイル削除処理
- 添付ファイル一覧のページネーション処理

### 🎬 動画管理（Video）

- 動画登録API
- 動画タイトル、カテゴリー、チャンネル、プレビュー画像ID、動画タイプ、ステータスなどの情報を扱うDTO・Entity
- Spring Data JPA Repositoryを利用した動画情報の保存処理

※動画登録以外の一覧・詳細・更新・削除などの動画APIは、確認したソースコードでは実装を確認できていないため、本READMEでは実装済み機能として記載していません。

### 🧩 ドメインモデル

ソースコードには、以下のエンティティや関連モデルが定義されています。

- Profile
- Channel
- Video
- Category
- Tag
- Attachment
- VideoLike
- VideoCount

---

## 🛠️ 3. 使用技術（Technology Stack）

| 分類 | 技術 |
|---|---|
| Programming Language | Java 17 |
| Framework | Spring Boot 3.0.0 |
| Web | Spring Boot Starter Web |
| Security | Spring Security |
| Authentication | JWT（jjwt 0.9.1） |
| ORM | Spring Data JPA / Hibernate |
| Database | PostgreSQL |
| Database Migration | Flyway Core |
| Validation | Spring Boot Starter Validation |
| API Documentation | Springdoc OpenAPI 2.0.0 |
| Email | Spring Boot Starter Mail |
| Build Tool | Maven |
| Other Libraries | Lombok、JAXB API |
| Test | Spring Boot Starter Test、Spring Security Test |

---

## 🏗️ 4. システム構成（System Architecture）

本プロジェクトでは、Controller、Service、Repository、Entity、DTOを分けたSpring Bootアプリケーションの基本構成を採用しています。

| コンポーネント | 役割 |
|---|---|
| Controller | HTTPリクエストを受け取り、APIレスポンスを返す |
| Service | 認証、プロフィール、ファイル、動画関連の業務処理を担当 |
| Repository | Spring Data JPAを利用したデータアクセス |
| Entity | PostgreSQLに保存するデータモデル |
| DTO | APIのリクエスト・レスポンスデータを管理 |
| Spring Security / JWT Filter | JWTを検証し、認証情報をSecurityContextに設定 |
| PostgreSQL | ユーザー、動画、チャンネル、添付ファイルなどの情報を保存 |

---

## 🔌 5. 主なAPI（確認できたエンドポイント）

| HTTP Method | Endpoint | 概要 |
|---|---|---|
| POST | `/auth/login` | ログイン |
| POST | `/auth/register` | ユーザー登録 |
| GET | `/auth/verification/email/{jwtToken}` | メールアドレス認証 |
| POST | `/attach/upload` | ファイルアップロード |
| GET | `/attach/open/{id}` | 画像表示 |
| GET | `/attach/open_general/{id}` | ファイルデータ取得 |
| GET | `/attach/download/{id}` | ファイルダウンロード |
| GET | `/attach/admin/page` | 添付ファイル一覧（ページング） |
| DELETE | `/attach/admin/{id}` | 添付ファイル削除 |
| POST | `/video/create` | 動画登録 |
| PUT | `/profile/update_user` | プロフィール更新 |
| PUT | `/profile/update_password` | パスワード変更 |
| PUT | `/profile/update_email` | メールアドレス変更 |
| POST | `/profile/user/create` | ユーザー情報作成 |

※上記はControllerでマッピングを確認できたURLです。認可設定やServiceの実装状況により、実行条件・利用可否が異なる場合があります。

---

## 📁 6. ディレクトリ構成（Project Structure）

```text
src/
├── main/
│   ├── java/com/example/
│   │   ├── config/          # Spring Security、JWT、Swagger等の設定
│   │   ├── controller/      # REST API Controller
│   │   │   ├── videoController/
│   │   │   └── ...
│   │   ├── dto/             # Request / Response DTO
│   │   ├── entity/          # JPA Entity
│   │   │   └── video/
│   │   ├── enums/           # Role、Status、VideoType等
│   │   ├── exp/             # 独自例外クラス
│   │   ├── repository/      # Spring Data JPA Repository
│   │   │   └── video/
│   │   ├── service/         # ビジネスロジック
│   │   │   └── video/
│   │   └── util/            # JWT等のユーティリティ
│   │
│   └── resources/
│       ├── db/migration/    # Flyway SQL
│       ├── messages/        # 多言語メッセージ
│       └── application.properties
│
└── test/
    └── java/com/example/
```

---

## 🚀 7. 実行環境・起動方法（Setup & Installation）

### 前提条件

- JDK 17
- Apache Maven
- PostgreSQL

### Step 1. リポジトリを取得

```bash
git clone <リポジトリURL>
cd YouTube
```

### Step 2. PostgreSQLを準備

PostgreSQLを起動し、アプリケーション用のデータベースを作成してください。

`application.properties`に設定されているデータベース接続先を、ご自身の環境に合わせて変更してください。

### Step 3. アプリケーション設定

設定ファイル：

```text
src/main/resources/application.properties
```

以下の設定をローカル環境に合わせて行ってください。

- PostgreSQL接続URL
- データベースユーザー名・パスワード
- メール送信サーバーのホスト・ポート
- メール送信アカウント・パスワード
- 添付ファイル保存先
- アプリケーションURL

**セキュリティ上の注意：** データベースやメールアカウントの認証情報をGitHubに公開しないでください。環境変数やGit管理対象外の外部設定ファイルで管理してください。

### Step 4. アプリケーションを起動

```bash
mvn spring-boot:run
```

または、JARファイルをビルドして起動できます。

```bash
mvn clean package
java -jar target/YouTube-0.0.1-SNAPSHOT.jar
```

※実際の起動には、PostgreSQLおよびメール送信設定などの環境準備が必要です。

---

## 🌐 8. APIドキュメント

本プロジェクトにはSpringdoc OpenAPIを導入しています。アプリケーション起動後、以下のURLからSwagger UIにアクセスできます。

```text
http://localhost:8080/swagger-ui/index.html
```

※Swagger UIの表示には、アプリケーションが正常に起動している必要があります。

---

## 🧪 9. テスト

テストコードの実行には、以下のコマンドを使用します。

```bash
mvn test
```

現時点でリポジトリ内に確認できるテストクラスは、Spring Bootアプリケーションのコンテキスト起動テストです。各APIの網羅的なテストが実装済みであるとは記載していません。

---

## 📚 10. 開発を通じて学んだこと（What I Learned）

- Spring Bootを利用したREST APIの基本構成
- Controller / Service / Repository / Entity / DTOの役割分担
- Spring Data JPAとPostgreSQLを利用したデータアクセス
- Spring Securityによる認証・認可設定
- JWTの発行およびリクエスト時の検証
- メール送信を利用したアカウント認証フロー
- MultipartFileを利用したファイルアップロード
- Swagger / OpenAPIによるAPIドキュメント作成
- Flywayによるデータベース変更管理の基礎
- チームでの開発を通じたコミュニケーションと共同作業

---

## 🔧 11. 今後の改善課題（Future Improvements）

- パスワード保存方式を安全なPasswordEncoder（BCrypt等）へ変更する
- JWTシークレットやDB・メール認証情報を環境変数で管理する
- プロフィール更新処理やメールアドレス変更処理の入力検証・例外処理を見直す
- 動画一覧・詳細・更新・削除APIを拡充する
- ファイルアップロード時の拡張子・サイズ・コンテンツ検証を強化する
- Controller / Serviceの単体テスト・結合テストを追加する
- FlywayのマイグレーションとJPAのスキーマ管理方針を整理する

---

**本プロジェクトは、IT Academyでチーム開発として取り組んだ学習プロジェクトです。**
