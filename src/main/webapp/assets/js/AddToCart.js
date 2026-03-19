// Toast 
function showToast(message, type = 'info') {
    // Remove existing toast
    const existingToast = document.querySelector('.toast-notification');
    if (existingToast) {
        existingToast.remove();
    }

    // Create toast 
    const toast = document.createElement('div');
    toast.className = `toast-notification toast-${type}`;
    toast.innerHTML = `
        <div class="toast-content">
            <span class="toast-icon">${getToastIcon(type)}</span>
            <span class="toast-message">${message}</span>
        </div>
    `;

    document.body.appendChild(toast);
    setTimeout(() => toast.classList.add('show'), 10);
    setTimeout(() => {
        toast.classList.remove('show');
        setTimeout(() => toast.remove(), 300);
    }, 3000);
}

function getToastIcon(type) {
    switch (type) {
        case 'success': return '✓';
        case 'error': return '✕';
        case 'warning': return '⚠';
        default: return 'ℹ';
    }
}

function addToCartAjax(productId, quantity, contextPath) {
    fetch(`${contextPath}/add-cart?productId=${productId}&quantity=${quantity}`, {
        method: 'GET',
        headers: {
            'X-Requested-With': 'XMLHttpRequest'
        }
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                showToast(data.message, 'success');
                // Update cart count
                const cartCountElements = document.querySelectorAll('.cart-count, .cart-quantity');
                cartCountElements.forEach(el => {
                    if (data.cartCount) {
                        el.textContent = data.cartCount;
                        el.style.display = 'inline-block';
                    }
                });
            } else if (data.requireLogin) {
                showToast(data.message, 'warning');
                setTimeout(() => {
                    window.location.href = `${contextPath}/login.jsp`;
                }, 1500);
            } else {
                showToast(data.message, 'error');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            showToast('Có lỗi xảy ra khi thêm vào giỏ hàng', 'error');
        });
}

window.addToCart = function (productId, quantity, contextPath) {
    addToCartAjax(productId, quantity, contextPath);
};

document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('form[action*="add-cart"]').forEach(form => {
        form.addEventListener('submit', function (e) {
            e.preventDefault();

            const formData = new FormData(form);
            const productId = formData.get('productId');
            const quantity = formData.get('quantity') || 1;
            const contextPath = form.action.split('/add-cart')[0];

            addToCartAjax(productId, quantity, contextPath);
        });
    });

    document.querySelectorAll('[data-add-to-cart]').forEach(button => {
        button.addEventListener('click', function (e) {
            e.preventDefault();

            const productId = this.dataset.productId;
            const quantity = this.dataset.quantity || 1;
            const contextPath = this.dataset.contextPath || '';

            addToCartAjax(productId, quantity, contextPath);
        });
    });
});
