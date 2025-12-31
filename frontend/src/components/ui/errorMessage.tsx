interface ErrorMessageProps {
  message?: string;
  className?: string;
}

export default function ErrorMessage({
  message,
  className,
}: ErrorMessageProps) {
  if (!message) return null;

  return <span className={`text-red-400 ${className}`}>{`(${message})`}</span>;
}
