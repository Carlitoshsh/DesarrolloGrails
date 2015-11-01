package testdesarrollo

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.util.MultiValueMap
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

import javax.servlet.AsyncContext
import javax.servlet.DispatcherType
import javax.servlet.RequestDispatcher
import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.ServletInputStream
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession
import javax.servlet.http.Part
import java.security.Principal

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FileController implements MultipartHttpServletRequest{

    def beforeInterceptor = {
        println "Se va a ejecutar la action: ${actionUri}"
    }

    def afterInterceptor = {
        println "Se ha ejecutado la action: ${actionUri}"
    }

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond File.list(params), model: [fileInstanceCount: File.count()]
    }

    def show(File fileInstance) {
        respond fileInstance
    }

    def create() {
        respond new File(params)
    }





    def share(){
        render "no se ha implementado esta funcionalidad"
    }



    def upload(){
        def file = request.getFile('myFile')
        if (file.getContentType() == "text/plain" || file.getContentType() == "image/png"){
            return "Yes"
        }else {return "No"}

    }

    def download(){
        def upDownFile = File.findById(params.actualFile)
        upDownFile.setContent(params.getRequest().getParameter().getBytes())
        if(upDownFile.fileType.equals("text/plain")){
            upDownFile.setFileType(".txt")
        }
        if (upDownFile.fileType.equals("image/png")){
            upDownFile.setFileType(".png")
        }

        upDownFile.save()


    }

    @Transactional
    def save(File fileInstance) {
        if (fileInstance == null) {
            notFound()
            return
        }

        if (fileInstance.hasErrors()) {
            respond fileInstance.errors, view: 'create'
            return
        }

        fileInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'file.label', default: 'File'), fileInstance.id])
                redirect fileInstance
            }
            '*' { respond fileInstance, [status: CREATED] }
        }
    }

    def edit(File fileInstance) {
        respond fileInstance
    }

    @Transactional
    def update(File fileInstance) {
        if (fileInstance == null) {
            notFound()
            return
        }

        if (fileInstance.hasErrors()) {
            respond fileInstance.errors, view: 'edit'
            return
        }

        fileInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'File.label', default: 'File'), fileInstance.id])
                redirect fileInstance
            }
            '*' { respond fileInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(File fileInstance) {

        if (fileInstance == null) {
            notFound()
            return
        }

        fileInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'File.label', default: 'File'), fileInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'file.label', default: 'File'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    @Override
    HttpMethod getRequestMethod() {
        return null
    }

    @Override
    HttpHeaders getRequestHeaders() {
        return null
    }

    @Override
    HttpHeaders getMultipartHeaders(String paramOrFileName) {
        return null
    }

    @Override
    String getAuthType() {
        return null
    }

    @Override
    Cookie[] getCookies() {
        return new Cookie[0]
    }

    @Override
    long getDateHeader(String name) {
        return 0
    }

    @Override
    String getHeader(String name) {
        return null
    }

    @Override
    Enumeration<String> getHeaders(String name) {
        return null
    }

    @Override
    Enumeration<String> getHeaderNames() {
        return null
    }

    @Override
    int getIntHeader(String name) {
        return 0
    }

    @Override
    String getMethod() {
        return null
    }

    @Override
    String getPathInfo() {
        return null
    }

    @Override
    String getPathTranslated() {
        return null
    }

    @Override
    String getContextPath() {
        return null
    }

    @Override
    String getQueryString() {
        return null
    }

    @Override
    String getRemoteUser() {
        return null
    }

    @Override
    boolean isUserInRole(String role) {
        return false
    }

    @Override
    Principal getUserPrincipal() {
        return null
    }

    @Override
    String getRequestedSessionId() {
        return null
    }

    @Override
    String getRequestURI() {
        return null
    }

    @Override
    StringBuffer getRequestURL() {
        return null
    }

    @Override
    String getServletPath() {
        return null
    }

    @Override
    HttpSession getSession(boolean create) {
        return null
    }

    @Override
    HttpSession getSession() {
        return null
    }

    @Override
    boolean isRequestedSessionIdValid() {
        return false
    }

    @Override
    boolean isRequestedSessionIdFromCookie() {
        return false
    }

    @Override
    boolean isRequestedSessionIdFromURL() {
        return false
    }

    @Override
    boolean isRequestedSessionIdFromUrl() {
        return false
    }

    @Override
    boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        return false
    }

    @Override
    void login(String username, String password) throws ServletException {

    }

    @Override
    void logout() throws ServletException {

    }

    @Override
    Collection<Part> getParts() throws IOException, ServletException {
        return null
    }

    @Override
    Part getPart(String name) throws IOException, ServletException {
        return null
    }

    @Override
    Iterator<String> getFileNames() {
        return null
    }

    @Override
    MultipartFile getFile(String name) {
        return null
    }

    @Override
    List<MultipartFile> getFiles(String name) {
        return null
    }

    @Override
    Map<String, MultipartFile> getFileMap() {
        return null
    }

    @Override
    MultiValueMap<String, MultipartFile> getMultiFileMap() {
        return null
    }

    @Override
    String getMultipartContentType(String paramOrFileName) {
        return null
    }

    @Override
    Object getAttribute(String name) {
        return null
    }

    @Override
    Enumeration<String> getAttributeNames() {
        return null
    }

    @Override
    String getCharacterEncoding() {
        return null
    }

    @Override
    void setCharacterEncoding(String env) throws UnsupportedEncodingException {

    }

    @Override
    int getContentLength() {
        return 0
    }

    @Override
    String getContentType() {
        return null
    }

    @Override
    ServletInputStream getInputStream() throws IOException {
        return null
    }

    @Override
    String getParameter(String name) {
        return null
    }

    @Override
    Enumeration<String> getParameterNames() {
        return null
    }

    @Override
    String[] getParameterValues(String name) {
        return new String[0]
    }

    @Override
    Map<String, String[]> getParameterMap() {
        return null
    }

    @Override
    String getProtocol() {
        return null
    }

    @Override
    String getScheme() {
        return null
    }

    @Override
    String getServerName() {
        return null
    }

    @Override
    int getServerPort() {
        return 0
    }

    @Override
    BufferedReader getReader() throws IOException {
        return null
    }

    @Override
    String getRemoteAddr() {
        return null
    }

    @Override
    String getRemoteHost() {
        return null
    }

    @Override
    void setAttribute(String name, Object o) {

    }

    @Override
    void removeAttribute(String name) {

    }

    @Override
    Locale getLocale() {
        return null
    }

    @Override
    Enumeration<Locale> getLocales() {
        return null
    }

    @Override
    boolean isSecure() {
        return false
    }

    @Override
    RequestDispatcher getRequestDispatcher(String path) {
        return null
    }

    @Override
    String getRealPath(String path) {
        return null
    }

    @Override
    int getRemotePort() {
        return 0
    }

    @Override
    String getLocalName() {
        return null
    }

    @Override
    String getLocalAddr() {
        return null
    }

    @Override
    int getLocalPort() {
        return 0
    }

    @Override
    ServletContext getServletContext() {
        return null
    }

    @Override
    AsyncContext startAsync() throws IllegalStateException {
        return null
    }

    @Override
    AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return null
    }

    @Override
    boolean isAsyncStarted() {
        return false
    }

    @Override
    boolean isAsyncSupported() {
        return false
    }

    @Override
    AsyncContext getAsyncContext() {
        return null
    }

    @Override
    DispatcherType getDispatcherType() {
        return null
    }
}
