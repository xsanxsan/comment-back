package com.example.demo.application.usecase;

import com.example.demo.application.ICommentDependency;
import com.example.demo.domain.Comment;
import com.example.demo.domain.User;
import com.example.demo.exceptions.CommentNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class AddReplyUseCaseTests {

    @Mock
    private ICommentDependency commentDependency;

    @InjectMocks
    private AddReplyUseCase addReplyUseCase;

    @Test
    public void shouldThrowAnExceptionIfTheCommentRepliedToIsNotFound() {
        // Given
        var addReplyDto = new AddReplyDto(null, null, "Xsan");
        BDDMockito.given(commentDependency.getCommentById(addReplyDto.repliedCommentId))
                .willReturn(Optional.empty());

        // When
        assertThrows(CommentNotFoundException.class, () -> addReplyUseCase.addReplyUseCase(addReplyDto));
    }

    @Test
    public void shouldAddReplyToComment() {
        // Given
        var addReplyDto = new AddReplyDto("Reply content", 1, "Xsan");
        BDDMockito.given(commentDependency.getCommentById(addReplyDto.repliedCommentId))
                .willReturn(
                        Optional.of(
                                Comment.builder()
                                        .id(addReplyDto.repliedCommentId)
                                        .score(0)
                                        .content("Test content")
                                        .createdAt(LocalDateTime.of(2015,
                                                Month.JULY, 29, 19, 30, 40))
                                        .isEdited(false)
                                        .user(new User("test", "/path/to/image.png"))
                                        .build()
                        )
                );
        addReplyUseCase.addReplyUseCase(addReplyDto);

        Mockito.verify(commentDependency, Mockito.times(1)).getCommentById(addReplyDto.repliedCommentId);
        Mockito.verify(commentDependency, Mockito.times(1)).addReply(any(), any());
    }

}
