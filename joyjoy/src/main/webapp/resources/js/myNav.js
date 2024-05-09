$(document).ready(function() {
    // 페이지 로드시 active 클래스 추가
    let profileLinks = document.querySelectorAll('.navbar-nav a');
    profileLinks.forEach(function(link) {
        // 주소가 "/user/mypost"로 시작하는 경우에만 active 클래스 추가
        if (link.getAttribute('href').startsWith("/user/mypost")) {
            link.classList.add('active');
        }
    });
});