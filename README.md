# Movies Select 🎬

A collaborative movie tracking platform where users can create and join "parties" (groups) to share movie lists, mark watched movies together, and enjoy a social movie-watching experience with friends. Features include moderation system, party ownership, and shared watchlists.

## ✨ Features

### Core Features
- 🎉 **Party System**: Create and manage movie parties (groups)
- 👥 **Social Collaboration**: Share movie lists with friends and party members
- ✅ **Watch Tracking**: Mark movies as watched within your party
- 🎬 **Movie Discovery**: Browse and search movies using TMDb API integration
- 👑 **Party Ownership**: Party creators have full control over their groups
- 🛡️ **Moderation System**: Assign moderators to help manage parties
- 🔒 **User Authentication**: Secure JWT-based authentication system

### Additional Features
- **Responsive Design**: Fully responsive UI with dark/light theme support
- **Real-time Updates**: React Query for efficient data fetching and caching
- **Member Management**: Add, remove, and manage party members
- **Privacy Controls**: Public and private party options
- **Activity Feed**: Track party activities and member interactions
- **Movie Recommendations**: Discover movies based on party preferences

## 🛠 Tech Stack

### Frontend
- **Framework**: Next.js 16 (React 19)
- **Language**: TypeScript
- **Styling**: Tailwind CSS 4
- **State Management**: Zustand
- **Data Fetching**: TanStack React Query (v5)
- **UI Components**: Radix UI
- **HTTP Client**: Axios
- **Authentication**: JWT Decode
- **Theme**: next-themes

### Backend
- **Framework**: Spring Boot 3.4.5
- **Language**: Java 17
- **Architecture**: Hexagonal Architecture (Ports and Adapters)
- **Security**: Spring Security + OAuth2 Resource Server
- **Database**: PostgreSQL 
- **ORM**: Spring Data JPA
- **API Client**: Spring WebFlux
- **Validation**: Bean Validation
- **Mapping**: MapStruct 1.6.3
- **Build Tool**: Maven

### Infrastructure
- **Database**: PostgreSQL
- **Containerization**: Docker (with Docker Compose)
- **External API**: The Movie Database (TMDb) API
- **Pipeline**

## 🏗 Architecture

### Hexagonal Architecture (Ports and Adapters)

The backend follows **Hexagonal Architecture** (also known as Ports and Adapters pattern), ensuring clean separation of concerns and making the application highly maintainable, testable, and framework-independent.

#### Architecture Overview

```
┌─────────────────────────────────────────────────────────────┐
│                     INPUT ADAPTERS                           │
│        (REST Controllers, Security Configuration)            │
└──────────────────────┬──────────────────────────────────────┘
                       │
                       ▼
                  ┌─────────┐
                  │  PORTS  │ (Input Ports / Use Cases)
                  └────┬────┘
                       │
                       ▼
┌─────────────────────────────────────────────────────────────┐
│                    APPLICATION CORE                          │
│         (Domain Models, Business Logic, Rules)               │
│                  Framework Independent                       │
└──────────────────────┬──────────────────────────────────────┘
                       │
                       ▼
                  ┌─────────┐
                  │  PORTS  │ (Output Ports)
                  └────┬────┘
                       │
                       ▼
┌─────────────────────────────────────────────────────────────┐
│                    OUTPUT ADAPTERS                           │
│      (JPA Repositories, External APIs, File System)          │
└─────────────────────────────────────────────────────────────┘
```

#### Key Principles

1. **Domain-Centric Design**: Business logic (party rules, moderation, permissions) is isolated from infrastructure
2. **Dependency Inversion**: Dependencies point inward toward the domain
3. **Testability**: Core domain can be tested without external dependencies
4. **Flexibility**: Easy to swap implementations (database, API clients, etc.)
5. **Maintainability**: Clear boundaries between layers reduce coupling

#### Layer Responsibilities

**Domain Layer (Core)**
- Contains business entities: User, Party, Movie, PartyMember, Moderation
- Domain logic: Party permissions, moderation rules, watch tracking
- No dependencies on frameworks or external libraries
- Pure Java objects (POJOs)

**Application Layer**
- Defines use cases: CreatePartyUseCase, ManageMembersUseCase, TrackMovieWatchUseCase
- Orchestrates domain objects
- Defines output ports (interfaces)

**Adapters Layer**
- **Input Adapters**: REST controllers, security configurations
- **Output Adapters**: Database repositories, external API clients (TMDb)

### Domain Model

```
User ──────────────┐
  │                │
  │ owns           │ joins
  │                │
  ▼                ▼
Party ──────── PartyMember
  │                │
  │ contains       │ moderates
  │                │
  ▼                ▼
PartyMovie ──── Moderation
  │
  │ references
  │
  ▼
Movie (from TMDb)
```

### Frontend Architecture

The frontend follows a modern React architecture with:
- **Component-Based Design**: Reusable UI components for parties, movies, and members
- **Custom Hooks**: Encapsulated business logic for party management
- **State Management**: Zustand for global state (auth, current party)
- **Server State**: React Query for API data management

## 📁 Project Structure

### Complete Project Structure

```
movies-select/
├── frontend/                    # Next.js Application
│   ├── src/
│   │   ├── @types/             # TypeScript global type declarations
│   │   ├── app/                # Next.js App Router
│   │   │   ├── (auth)/         # Authentication pages
│   │   │   │   ├── login/
│   │   │   │   └── register/
│   │   │   ├── (main)/         # Main application pages
│   │   │   │   ├── parties/    # Party list and management
│   │   │   │   ├── party/      # Individual party pages
│   │   │   │   │   └── [id]/
│   │   │   │   │       ├── movies/      # Party movie list
│   │   │   │   │       ├── members/     # Party members
│   │   │   │   │       └── settings/    # Party settings
│   │   │   │   ├── movies/     # Movie discovery
│   │   │   │   └── profile/    # User profile
│   │   │   ├── layout.tsx      # Root layout
│   │   │   └── page.tsx        # Home page
│   │   ├── components/         # React components
│   │   │   ├── ui/             # Base UI components (Radix UI)
│   │   │   ├── layout/         # Layout components
│   │   │   ├── party/          # Party-specific components
│   │   │   │   ├── PartyCard.tsx
│   │   │   │   ├── PartyList.tsx
│   │   │   │   ├── CreatePartyModal.tsx
│   │   │   │   ├── PartySettings.tsx
│   │   │   │   └── MemberList.tsx
│   │   │   ├── movie/          # Movie-specific components
│   │   │   │   ├── MovieCard.tsx
│   │   │   │   ├── MovieList.tsx
│   │   │   │   ├── WatchButton.tsx
│   │   │   │   └── AddToPartyModal.tsx
│   │   │   ├── moderation/     # Moderation components
│   │   │   │   ├── ModerationPanel.tsx
│   │   │   │   └── ModeratorBadge.tsx
│   │   │   └── auth/           # Authentication components
│   │   ├── constants/          # Application constants
│   │   ├── hooks/              # Custom React hooks
│   │   │   ├── useParty.ts
│   │   │   ├── usePartyMembers.ts
│   │   │   ├── useMovies.ts
│   │   │   └── useAuth.ts
│   │   ├── lib/                # Utilities and helpers
│   │   ├── services/           # API services layer
│   │   │   ├── api/            # Axios instance and interceptors
│   │   │   ├── auth/           # Authentication service
│   │   │   ├── parties/        # Parties service
│   │   │   ├── movies/         # Movies service
│   │   │   └── members/        # Members service
│   │   ├── stores/             # Zustand stores
│   │   │   ├── auth.ts         # Authentication state
│   │   │   ├── party.ts        # Current party state
│   │   │   └── user.ts         # User state
│   │   ├── styles/             # Global styles
│   │   └── types/              # TypeScript interfaces
│   │       ├── party.ts
│   │       ├── movie.ts
│   │       ├── user.ts
│   │       └── member.ts
│   ├── public/                 # Static assets
│   ├── package.json
│   ├── next.config.ts
│   └── tailwind.config.ts
│
├── backend/                     # Spring Boot Application
│   └── src/
│       ├── main/
│       │   ├── java/br/com/armardur/
│       │   │   │
│       │   │   ├── domain/              # Domain Layer (Core)
│       │   │   │   ├── model/           # Domain Entities
│       │   │   │   │   ├── User.java
│       │   │   │   │   ├── Party.java
│       │   │   │   │   ├── PartyMember.java
│       │   │   │   │   ├── Movie.java
│       │   │   │   │   ├── PartyMovie.java
│       │   │   │   │   └── WatchStatus.java
│       │   │   │   ├── exception/       # Domain Exceptions
│       │   │   │   │   ├── PartyNotFoundException.java
│       │   │   │   │   ├── UnauthorizedAccessException.java
│       │   │   │   │   ├── MemberAlreadyExistsException.java
│       │   │   │   │   └── InsufficientPermissionsException.java
│       │   │   │   ├── vo/              # Value Objects
│       │   │   │   │   ├── PartyRole.java (OWNER, MODERATOR, MEMBER)
│       │   │   │   │   └── PartyStatus.java (ACTIVE, ARCHIVED)
│       │   │   │   └── service/         # Domain Services
│       │   │   │       ├── PartyPermissionService.java
│       │   │   │       └── ModerationService.java
│       │   │   │
│       │   │   ├── application/         # Application Layer
│       │   │   │   ├── port/
│       │   │   │   │   ├── in/          # Input Ports (Use Cases)
│       │   │   │   │   │   ├── party/
│       │   │   │   │   │   │   ├── CreatePartyUseCase.java
│       │   │   │   │   │   │   ├── UpdatePartyUseCase.java
│       │   │   │   │   │   │   ├── DeletePartyUseCase.java
│       │   │   │   │   │   │   ├── GetPartyUseCase.java
│       │   │   │   │   │   │   └── ListPartiesUseCase.java
│       │   │   │   │   │   ├── member/
│       │   │   │   │   │   │   ├── AddMemberUseCase.java
│       │   │   │   │   │   │   ├── RemoveMemberUseCase.java
│       │   │   │   │   │   │   ├── UpdateMemberRoleUseCase.java
│       │   │   │   │   │   │   └── ListMembersUseCase.java
│       │   │   │   │   │   ├── movie/
│       │   │   │   │   │   │   ├── AddMovieToPartyUseCase.java
│       │   │   │   │   │   │   ├── RemoveMovieFromPartyUseCase.java
│       │   │   │   │   │   │   ├── MarkMovieAsWatchedUseCase.java
│       │   │   │   │   │   │   └── GetPartyMoviesUseCase.java
│       │   │   │   │   │   ├── auth/
│       │   │   │   │   │   │   ├── RegisterUserUseCase.java
│       │   │   │   │   │   │   └── AuthenticateUserUseCase.java
│       │   │   │   │   │   └── search/
│       │   │   │   │   │       └── SearchMoviesUseCase.java
│       │   │   │   │   │
│       │   │   │   │   └── out/         # Output Ports
│       │   │   │   │       ├── UserRepositoryPort.java
│       │   │   │   │       ├── PartyRepositoryPort.java
│       │   │   │   │       ├── PartyMemberRepositoryPort.java
│       │   │   │   │       ├── MovieRepositoryPort.java
│       │   │   │   │       ├── PartyMovieRepositoryPort.java
│       │   │   │   │       └── ExternalMovieApiPort.java
│       │   │   │   │
│       │   │   │   └── service/         # Application Services
│       │   │   │       ├── UserService.java
│       │   │   │       ├── AuthService.java
│       │   │   │       ├── PartyService.java
│       │   │   │       ├── PartyMemberService.java
│       │   │   │       ├── MovieService.java
│       │   │   │       └── PartyMovieService.java
│       │   │   │
│       │   │   └── adapter/             # Adapters Layer
│       │   │       │
│       │   │       ├── in/              # Input Adapters
│       │   │       │   ├── rest/        # REST Controllers
│       │   │       │   │   ├── AuthController.java
│       │   │       │   │   ├── PartyController.java
│       │   │       │   │   ├── PartyMemberController.java
│       │   │       │   │   ├── PartyMovieController.java
│       │   │       │   │   ├── MovieController.java
│       │   │       │   │   ├── UserController.java
│       │   │       │   │   └── dto/     # Request/Response DTOs
│       │   │       │   │       ├── request/
│       │   │       │   │       │   ├── CreatePartyRequest.java
│       │   │       │   │       │   ├── AddMemberRequest.java
│       │   │       │   │       │   ├── UpdateRoleRequest.java
│       │   │       │   │       │   └── AddMovieRequest.java
│       │   │       │   │       └── response/
│       │   │       │   │           ├── PartyResponse.java
│       │   │       │   │           ├── MemberResponse.java
│       │   │       │   │           └── MovieResponse.java
│       │   │       │   │
│       │   │       │   ├── security/    # Security Configuration
│       │   │       │   │   ├── SecurityConfig.java
│       │   │       │   │   ├── JwtAuthenticationFilter.java
│       │   │       │   │   └── JwtTokenProvider.java
│       │   │       │   │
│       │   │       │   └── config/      # General Configuration
│       │   │       │       ├── CorsConfig.java
│       │   │       │       └── WebConfig.java
│       │   │       │
│       │   │       └── out/             # Output Adapters
│       │   │           ├── persistence/ # Database Adapter
│       │   │           │   ├── entity/  # JPA Entities
│       │   │           │   │   ├── UserEntity.java
│       │   │           │   │   ├── PartyEntity.java
│       │   │           │   │   ├── PartyMemberEntity.java
│       │   │           │   │   ├── MovieEntity.java
│       │   │           │   │   └── PartyMovieEntity.java
│       │   │           │   ├── repository/  # JPA Repositories
│       │   │           │   │   ├── UserJpaRepository.java
│       │   │           │   │   ├── PartyJpaRepository.java
│       │   │           │   │   ├── PartyMemberJpaRepository.java
│       │   │           │   │   ├── MovieJpaRepository.java
│       │   │           │   │   └── PartyMovieJpaRepository.java
│       │   │           │   └── adapter/     # Repository Adapters
│       │   │           │       ├── UserRepositoryAdapter.java
│       │   │           │       ├── PartyRepositoryAdapter.java
│       │   │           │       ├── PartyMemberRepositoryAdapter.java
│       │   │           │       └── MovieRepositoryAdapter.java
│       │   │           │
│       │   │           └── external/        # External API Adapter
│       │   │               ├── tmdb/
│       │   │               │   ├── TmdbApiClient.java
│       │   │               │   ├── TmdbApiAdapter.java
│       │   │               │   └── dto/     # TMDb API DTOs
│       │   │               └── mapper/      # MapStruct Mappers
│       │   │                   ├── MovieMapper.java
│       │   │                   ├── PartyMapper.java
│       │   │                   └── MemberMapper.java
│       │   │
│       │   └── resources/
│       │       ├── application.yml
│       │       ├── application-dev.yml
│       │       ├── application-prod.yml
│       │       └── db/
│       │           └── migration/        # Flyway/Liquibase scripts
│       │
│       └── test/                         # Tests
│           ├── java/br/com/armardur/
│           │   ├── domain/               # Domain tests
│           │   │   ├── PartyPermissionServiceTest.java
│           │   │   └── ModerationServiceTest.java
│           │   ├── application/          # Use case tests
│           │   │   ├── CreatePartyUseCaseTest.java
│           │   │   └── ManageMembersUseCaseTest.java
│           │   └── adapter/              # Adapter tests
│           │       ├── PartyControllerTest.java
│           │       └── PartyRepositoryAdapterTest.java
│           └── resources/
│
├── docker-compose.yml           # Docker Compose configuration
├── .env                        # Environment variables
├── .gitignore
└── README.md
```

### Database Schema

```sql
-- Core Tables
users (id, username, email, password, created_at)
parties (id, name, description, owner_id, status, created_at)
party_members (id, party_id, user_id, role, joined_at)
movies (id, tmdb_id, title, poster_path, release_date)
party_movies (id, party_id, movie_id, added_by, added_at)
watch_status (id, party_movie_id, user_id, watched, watched_at)
```

### Architecture Benefits in This Project

1. **Independent Testing**: Party permission logic can be tested without Spring Boot
2. **Framework Independence**: Could migrate from Spring Boot to Quarkus with minimal changes
3. **Database Flexibility**: Easy to switch from PostgreSQL to MongoDB
4. **API Changes**: TMDb API changes only affect the external adapter
5. **Business Rule Changes**: Moderation rules can evolve without affecting infrastructure

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

- **Node.js**: v20 or higher
- **Java**: JDK 17
- **Maven**: 3.6+
- **PostgreSQL**: 14+ (or use Docker Compose)
- **Docker & Docker Compose**: Latest version (optional, for containerized setup)
- **TMDb API Key**: Get yours at [The Movie Database](https://www.themoviedb.org/settings/api)

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/arielschmeing/movies-select.git
cd movies-select
```

### 2. Install Frontend Dependencies

```bash
cd frontend
npm install
```

### 3. Install Backend Dependencies

```bash
cd backend
mvn clean install
```

## ⚙️ Configuration

### Environment Variables

#### Root Directory (`.env`)

Create a `.env` file in the root directory for Docker Compose:

```env
POSTGRES_DB=movies_select_db
POSTGRES_USER=postgres
POSTGRES_PASSWORD=password
SPRING_EXTERNAL_API_URL=https://api.themoviedb.org/3/movie/
SPRING_EXTERNAL_API_TOKEN=your_tmdb_api_token_here
```

#### Frontend Configuration

Create a `.env.local` file in the `frontend` directory:

```env
NEXT_PUBLIC_API_URL=http://localhost:8080
```

#### Backend Configuration

Update `backend/src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/movies_select_db
    username: postgres
    password: password
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

external:
  api:
    url: ${SPRING_EXTERNAL_API_URL:https://api.themoviedb.org/3/movie/}
    token: ${SPRING_EXTERNAL_API_TOKEN}

server:
  port: 8080

jwt:
  secret: your-secret-key-here
  expiration: 86400000 # 24 hours
```

### Obtaining TMDb API Token

1. Visit [The Movie Database](https://www.themoviedb.org/)
2. Create an account or sign in
3. Go to Settings → API
4. Request an API key
5. Copy your API Read Access Token (v4 auth)
6. Add it to your `.env` file

## 🎮 Running the Application

### Option 1: Using Docker Compose (Recommended)

```bash
# From the root directory
docker-compose up -d
```

This will start:
- PostgreSQL database on port 5432
- Backend API on port 8080
- Frontend application on port 3000

### Option 2: Manual Setup

#### Start PostgreSQL

```bash
# Using Docker
docker run --name movies-postgres \
  -e POSTGRES_DB=movies_select_db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=password \
  -p 5432:5432 \
  -d postgres:latest
```

#### Run Backend

```bash
cd backend
mvn spring-boot:run
```

The backend will be available at `http://localhost:8080`

#### Run Frontend

```bash
cd frontend
npm run dev
```

The frontend will be available at `http://localhost:3000`

### Build for Production

#### Frontend

```bash
cd frontend
npm run build
npm start
```

#### Backend

```bash
cd backend
mvn clean package
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

## 📚 API Documentation

### Authentication Endpoints

```
POST   /api/auth/register          - Register a new user
POST   /api/auth/login             - Login and receive JWT token
POST   /api/auth/refresh           - Refresh JWT token
GET    /api/auth/me                - Get current user info
```

### Party Endpoints

```
GET    /api/parties                - Get all parties (paginated)
POST   /api/parties                - Create a new party
GET    /api/parties/{id}           - Get party by ID
PUT    /api/parties/{id}           - Update party (owner/moderator only)
DELETE /api/parties/{id}           - Delete party (owner only)
GET    /api/parties/my-parties     - Get user's parties
GET    /api/parties/{id}/stats     - Get party statistics
```

### Party Member Endpoints

```
GET    /api/parties/{id}/members            - Get all party members
POST   /api/parties/{id}/members            - Add member to party
DELETE /api/parties/{id}/members/{userId}   - Remove member (owner/moderator)
PUT    /api/parties/{id}/members/{userId}   - Update member role (owner only)
POST   /api/parties/{id}/join               - Join public party
POST   /api/parties/{id}/leave              - Leave party
```

### Party Movie Endpoints

```
GET    /api/parties/{id}/movies                    - Get all movies in party
POST   /api/parties/{id}/movies                    - Add movie to party
DELETE /api/parties/{id}/movies/{movieId}          - Remove movie from party
POST   /api/parties/{id}/movies/{movieId}/watch    - Mark movie as watched
DELETE /api/parties/{id}/movies/{movieId}/unwatch  - Mark movie as unwatched
GET    /api/parties/{id}/movies/watched            - Get watched movies
GET    /api/parties/{id}/movies/unwatched          - Get unwatched movies
```

### Movie Discovery Endpoints

```
GET    /api/movies/search?query={query}    - Search movies
GET    /api/movies/popular                 - Get popular movies
GET    /api/movies/trending                - Get trending movies
GET    /api/movies/{id}                    - Get movie details
GET    /api/movies/{id}/recommendations    - Get movie recommendations
```

### User Endpoints

```
GET    /api/users/me                - Get current user profile
PUT    /api/users/me                - Update user profile
GET    /api/users/{id}              - Get user profile by ID
GET    /api/users/me/parties        - Get user's parties
GET    /api/users/me/statistics     - Get user statistics
```

### Health Check

```
GET    /actuator/health             - Application health status
GET    /actuator/info               - Application information
```

### Request/Response Examples

#### Create Party

```json
POST /api/parties
{
  "name": "Friends Movie Night",
  "description": "Weekly movie nights with the crew",
  "isPublic": false
}
```

#### Add Movie to Party

```json
POST /api/parties/1/movies
{
  "tmdbId": 550,
  "title": "Fight Club",
  "posterPath": "/path/to/poster.jpg",
  "releaseDate": "1999-10-15"
}
```

#### Mark Movie as Watched

```json
POST /api/parties/1/movies/550/watch
{
  "watchedAt": "2026-01-14T20:30:00Z",
  "rating": 9,
  "comment": "Amazing movie!"
}
```

## 🧪 Testing

### Backend Tests

```bash
cd backend

# Run all tests
mvn test

# Run unit tests only
mvn test -Dtest=*UnitTest

# Run integration tests
mvn test -Dtest=*IntegrationTest

# Generate test coverage report
mvn test jacoco:report
```

### Frontend Tests

```bash
cd frontend

# Run tests
npm test

# Run tests with coverage
npm run test:coverage

# Run E2E tests
npm run test:e2e
```

## 👥 User Roles & Permissions

### Owner
- Full control over the party
- Can delete the party
- Can assign/remove moderators
- Can add/remove members
- Can add/remove movies
- Can mark movies as watched

### Moderator
- Can add/remove members
- Can add/remove movies
- Can mark movies as watched
- Cannot delete party or change owner
- Cannot assign other moderators

### Member
- Can view party content
- Can add movies (if allowed by party settings)
- Can mark their own watch status
- Cannot manage other members

## 🔒 Security Features

- JWT-based authentication
- Role-based access control (RBAC)
- Party-level permissions
- Secure password hashing (BCrypt)
- CORS configuration
- Input validation
- SQL injection prevention
- XSS protection

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Coding Standards

#### Backend (Java)
- Follow hexagonal architecture principles
- Keep domain layer free of framework dependencies
- Implement proper permission checks in domain services
- Use MapStruct for object mapping
- Write unit tests for domain and application layers
- Write integration tests for adapters

#### Frontend (TypeScript)
- Follow React best practices
- Use TypeScript for type safety
- Keep components small and focused
- Write meaningful prop types
- Use custom hooks for reusable logic
- Implement proper error handling

## 👤 Author

**Ariel Schmeing**

- GitHub: [@arielschmeing](https://github.com/arielschmeing)

---
