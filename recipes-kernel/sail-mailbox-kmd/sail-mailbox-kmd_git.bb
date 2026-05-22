DESCRIPTION = "Qualcomm SAIL Mailbox Kernel Driver"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=801f80980d171dd6425610833a22dbe6"

SRCPROJECT = "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/sail-mailbox-kmd.git;protocol=https"
SRCBRANCH  = "sail-mailbox-kernel.lnx.1.0.r1-rel"
SRCREV     = "e5044f27f4a42967561c09e0baff9f9c88dde101"

SRC_URI = "${SRCPROJECT};branch=${SRCBRANCH};destsuffix=sail-mailbox/sail-mb-kmd \
    file://0001-sail-mailbox-fix-kernel-6.18-API-changes.patch \
"

# destsuffix unpacks to ${UNPACKDIR}/sail-mailbox/sail-mb-kmd in wrynose
# (reference uses ${WORKDIR} which is equivalent in older Yocto)
S = "${UNPACKDIR}/sail-mailbox/sail-mb-kmd"

inherit module

RPROVIDES:${PN} += "kernel-module-sail-kernel"

EXTRA_OEMAKE += "MACHINE='${MACHINE}'"
MAKE_TARGETS = "modules"
MODULES_INSTALL_TARGET = "modules_install"
KERNEL_MODULE_AUTOLOAD += "qcom-sail-mbox"
