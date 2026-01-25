create table if not exists book (
                                    id BIGSERIAL PRIMARY KEY,
                                    isbn VARCHAR(20) UNIQUE NOT NULL,
    title VARCHAR(255) NOT NULL,
    published_at DATE,
    author_id BIGINT NOT NULL,
    publication_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

create SEQUENCE if not exists book_id_seq;
