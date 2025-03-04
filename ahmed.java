document.addEventListener("DOMContentLoaded", function () {
    // تغيير لون الخلفية عند المرور على الأقسام
    const sections = document.querySelectorAll("section");
    sections.forEach(section => {
        section.addEventListener("mouseover", function () {
            this.style.backgroundColor = "#f0f0f0";
        });
        section.addEventListener("mouseout", function () {
            this.style.backgroundColor = "#fff";
        });
    });

    // تحريك شرائط التقدم
    const progressBars = document.querySelectorAll(".progress");
    progressBars.forEach(bar => {
        const progressValue = bar.getAttribute("data-progress");
        if (progressValue) {
            bar.style.width = progressValue + "%";
        }
    });

    // تفعيل القائمة المنسدلة
    function toggleMenu() {
        const nav = document.getElementById('navMenu'); // تأكد من أن الـ ID صحيح
        nav.classList.toggle('open');
    }

    // إغلاق القائمة عند النقر خارجها
    document.addEventListener('click', function (e) {
        const navMenu = document.getElementById('navMenu');
        const menuIcon = document.querySelector('.menu-icon');
        if (!menuIcon.contains(e.target) && !navMenu.contains(e.target)) {
            navMenu.classList.remove('open');
        }
    });

    // تأثير التموج (Ripple Effect)
    document.addEventListener('click', function (e) {
        if (e.target.classList.contains('btn')) {
            const ripple = document.createElement('span');
            ripple.classList.add('ripple');
            e.target.appendChild(ripple);

            const rect = e.target.getBoundingClientRect();
            const size = Math.max(rect.width, rect.height);
            ripple.style.width = ripple.style.height = `${size}px`;
            ripple.style.left = `${e.clientX - rect.left - size / 2}px`;
            ripple.style.top = `${e.clientY - rect.top - size / 2}px`;

            ripple.addEventListener('animationend', () => {
                ripple.remove();
            });
        }
    });

    // إضافة تأثير التمرير على الشريط العلوي
    window.addEventListener('scroll', function () {
        const header = document.querySelector('header');
        if (window.scrollY > 50) {
            header.classList.add('scrolled');
        } else {
            header.classList.remove('scrolled');
        }
    });

    // تفعيل التبويبات
    const tabButtons = document.querySelectorAll('.tab-button');
    const certificateCategories = document.querySelectorAll('.certificate-category');

    tabButtons.forEach(button => {
        button.addEventListener('click', () => {
            // إزالة النشاط من جميع الأزرار
            tabButtons.forEach(btn => btn.classList.remove('active'));
            // إضافة النشاط للزر المحدد
            button.classList.add('active');

            // إخفاء جميع الأقسام
            certificateCategories.forEach(category => {
                category.classList.remove('active');
            });

            // إظهار القسم المحدد
            const categoryId = button.getAttribute('data-category');
            if (categoryId) {
                const targetCategory = document.getElementById(categoryId);
                if (targetCategory) {
                    targetCategory.classList.add('active');
                }
            }
        });
    });
});
// تبديل التبويبات
document.addEventListener("DOMContentLoaded", function () {
    const buttons = document.querySelectorAll(".tab-button");
    const categories = document.querySelectorAll(".certificate-category");

    buttons.forEach(button => {
        button.addEventListener("click", function () {
            // إزالة الكلاس "active" من جميع الأزرار
            buttons.forEach(btn => btn.classList.remove("active"));
            // إضافة الكلاس "active" للزر الحالي
            this.classList.add("active");

            // إخفاء جميع الفئات
            categories.forEach(category => category.classList.remove("active"));
            // عرض الفئة المحددة فقط
            document.getElementById(this.dataset.category).classList.add("active");
        });
    });
});
function checkEmptyCategory() {
    categories.forEach((category) => {
        if (category.classList.contains("active") && category.children.length === 0) {
            document.getElementById("no-certificates").style.display = "block";
        } else {
            document.getElementById("no-certificates").style.display = "none";
        }
    });
}
