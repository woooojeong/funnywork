# amf-portal-board

## API Specs
### 회원
#### 회원 등록 API
##### 기본 정보
`POST /api/v1/members`
##### Request
| Name     |  Type  | Description   | Required |
|----------|:------:|---------------|:--------:|
| name     | String | 사용자 이름        |    X     |
| nickname | String | 사용자 별명        |    X     |
| email    | String | 이메일(로그인 시 사용) |    O     |
| password | String | 비밀번호          |    O     |

##### Response
| Name | Type | Description    | Required |
|-----|:----:|----------------|:--------:|
|     | long | 생성된 사용자의 관리 ID |    X     |
* 생성 실패 시 -1을 리턴함


#### 회원 로그인 API
##### 기본 정보
`POST /api/v1/login`
##### Request
| Name     |  Type  | Description   | Required |
|----------|:------:|---------------|:--------:|
| email    | String | 이메일(로그인 시 사용) |    O     |
| password | String | 비밀번호          |    O     |

##### Response
| Name |  Type   | Description         | Required |
|-----|:-------:|---------------------|:--------:|
| login | boolean | 성공시 true, 실패시 false |    X     |
|||::: 이하 필드는 성공시에만 포함됨 ::: | |
| id | long | 사용자의 계정 관리 ID | |
| name | String | 사용자의 이름 | |
| email | String | 사용자의 이메일 | |


### 게시글
#### 게시글 등록 API
##### 기본 정보
`POST /api/v1/posts`
##### Request
| Name              |  Type  | Description   | Required |
|-------------------|:------:|---------------|:--------:|
| title             | String | 게시글 제목        |    O     |
| content           | String | 게시글 내용        |    O     |
| author.authorId   |  long  | 게시자의 계정 관리 ID |    X     |
| author.authorName | String | 게시자 이름        |    O     |

##### Response
| Name | Type | Description    | Required |
|-----|:----:|----------------|:--------:|
|     | long | 생성된 게시글의 관리 ID |    X     |

#### 게시글 목록 조회 API
##### 기본 정보
`GET /api/v1/posts`

##### Request
- 별도 변수 없음

##### Response
| Name         |       Type        | Description | Required |
|--------------|:-----------------:|-------------|:--------:|
| id           |       long        | 게시글의 관리 ID  |    X     |
| title        |      String       | 게시글의 제목     |    X     |
| author       |      String       | 게시자 이름      |    X     |
| modifiedDate | String(date-time) | 게시 일자       |    X     |


#### 게시글 단건 조회 API
##### 기본 정보
`GET /api/v1/posts/{id}` :: id는 게시글의 관리 ID

##### Request
- 별도 변수 없음

##### Response
| Name    |  Type  | Description | Required |
|---------|:------:|-------------|:--------:|
| id      |  long  | 게시글의 관리 ID  |    X     |
| title   | String | 게시글의 제목     |    X     |
| content | String | 게시글 내용      |    X     |
| author  | String | 게시자 이름      |    X     |


#### 게시글 수정 API
##### 기본 정보
`PUT /api/v1/posts/{id}` :: id는 게시글의 관리 ID

##### Request
| Name              |  Type  | Description   | Required |
|-------------------|:------:|---------------|:--------:|
| title             | String | 게시글 제목        |    O     |
| content           | String | 게시글 내용        |    O     |

##### Response
| Name | Type | Description    | Required |
|-----|:----:|----------------|:--------:|
|     | long | 수정된 게시글의 관리 ID |    X     |


#### 게시글 삭제 API
##### 기본 정보
`DELETE /api/v1/posts/{id}` :: id는 게시글의 관리 ID

##### Request
- 별도 변수 없음

##### Response
| Name | Type | Description    | Required |
|-----|:----:|----------------|:--------:|
|     | long | 삭제된 게시글의 관리 ID |    X     |
