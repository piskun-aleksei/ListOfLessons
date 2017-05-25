package com.bsuir.piskun.controllers;

import com.bsuir.piskun.beans.User;
import com.bsuir.piskun.services.AuthorizationService;
import com.bsuir.piskun.services.LessonService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class LoginControllerTest {

    @Mock
    private AuthorizationService authorizationService;

    @Mock
    private LessonService lessonService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @Mock
    private User user;

    @InjectMocks
    private LoginController process;

    /**
     * Initial method that is called to initialize mocks.
     *
     * @throws Exception may be thrown
     */
    @Before
    public final void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldProceedAfterRequestPublic() throws Exception {
        when(lessonService.select()).thenReturn(new ArrayList<>());
        when(request.getSession()).thenReturn(session);
        process.requestPublic(request);
        verify(lessonService, times(1)).select();
    }

    @Test
    public void shouldLogin() throws Exception {
        when(authorizationService.select("admin", "admin")).thenReturn(user);
        when(user.getLogin()).thenReturn("admin");
        when(user.getRank()).thenReturn(5);
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("login")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("admin");
        when(session.getAttribute("currentPage")).thenReturn("login");
        process.login(request);
        verify(session, times(2)).getAttribute("currentPage");
    }

    @Test
    public void shouldLogout() throws Exception {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("currentPage")).thenReturn("formAuth");
        process.logout(request);
        verify(session, times(1)).setAttribute("currentPage", "login");
    }

}